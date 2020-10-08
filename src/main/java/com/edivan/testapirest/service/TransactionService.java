package com.edivan.testapirest.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivan.testapirest.dao.TransactionRepository;
import com.edivan.testapirest.model.Account;
import com.edivan.testapirest.model.AccountTransaction;
import com.edivan.testapirest.model.Transaction;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction create(AccountTransaction act, Account account, String descriptionTransaction, Date date) {
		Transaction transaction = new Transaction(act, account, descriptionTransaction, date);
		return transactionRepository.save(transaction);
	}
}
