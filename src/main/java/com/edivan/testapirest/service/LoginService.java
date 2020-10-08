package com.edivan.testapirest.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	
	public boolean createToken(String email, String cpf) {
		EmailService emailcontroller = new EmailService();
		TokenService token = new TokenService();
		long rand = token.tokenGeneretor(cpf);
		if(rand != 0) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setText("Token: " + rand);
	        msg.setTo(email);
	        msg.setFrom("conta@zup.com");
	        
	        return emailcontroller.sendMail(msg);
		}
		
        return false;
        	
	}
    
	public boolean createPassword(String cpf, long token, String psw) {
		TokenService tokenService = new TokenService();
		if(tokenService.isValid(token)) {
			PersonService personService = new PersonService();
	
			if(personService.savePassword(cpf, psw) != null) return true;

		}
		
		return false;
		
	}

}
