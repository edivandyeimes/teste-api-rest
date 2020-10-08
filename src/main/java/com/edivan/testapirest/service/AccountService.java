package com.edivan.testapirest.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.edivan.testapirest.dao.AccountRepository;
import com.edivan.testapirest.dto.AccountTransactionDTO;
import com.edivan.testapirest.model.Account;



@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account create(Account account) {
		account = accountRepository.save(account);
		if(account != null) {
			EmailService email = new EmailService();
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setText("Sua conta foi criada com sucesso! Conta: " + account.getCode() 
			+ " Agência: " + account.getAgency() 
			+ " Banco: " + account.getBank() 
			+ " Saldo: " + account.getBalance() );
	        msg.setTo("user@gmail.com");
	        msg.setFrom("conta@zup.com");
			email.sendMail(msg);
		}
		
		return account;
	}
	
	@SuppressWarnings("deprecation")
	public Account transactionExtern(long id, String descriptionTransaction, AccountTransactionDTO act) {
		Account account = accountRepository.findById(id);
		double balance = account.getBalance();
		balance -= act.getValue();
		if(balance >= 0) {
			TransactionService transactionService = new TransactionService();
			Date dateTransaction = new Date(System.currentTimeMillis());
			
			if(dateTransaction.getHours() >= 17) {
				transactionService.create(act.transformToAct(), account, descriptionTransaction,dateTransaction);
				return accountRepository.updateBalance(id, balance);
			}
			
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(dateTransaction); 
			cal.add(Calendar.DATE, 1);
			dateTransaction = cal.getTime();
			transactionService.create(act.transformToAct(), account, descriptionTransaction, dateTransaction);
			
			return accountRepository.updateBalance(id, balance);
		}
				
		return null;
	}

}
