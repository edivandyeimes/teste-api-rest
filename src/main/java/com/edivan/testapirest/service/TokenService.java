package com.edivan.testapirest.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivan.testapirest.dao.TokenRepository;
import com.edivan.testapirest.model.Token;


@Service
public class TokenService {
	
	private static final long expirationPeriod = 3600000;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	

	public long tokenGeneretor(String cpf) {
		
		PersonService personService = new PersonService();
		Date criationDate = new Date(System.currentTimeMillis());
		Date expirationDate = new Date(System.currentTimeMillis() + expirationPeriod);
		long rand = (new Random()).nextInt(10000000) + 10000000;
		Token token = new Token(personService.findByCpf(cpf), rand, criationDate,expirationDate);
		token = tokenRepository.save(token);
		if (token.getId() != 0) {
			
			return rand;
		}
		
		return 0;
		
		
	}
	
	
	public boolean isValid(long value) {
		
		Token token = tokenRepository.findByValue(value);
		if(token.getExpirationDate().after(new Date(System.currentTimeMillis()))) {
			return true;
		}
		return false;
	}
}
