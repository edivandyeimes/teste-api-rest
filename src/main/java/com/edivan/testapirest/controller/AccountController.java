package com.edivan.testapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edivan.testapirest.dto.AccountDTO;
import com.edivan.testapirest.dto.AccountTransactionDTO;
import com.edivan.testapirest.model.Account;

import com.edivan.testapirest.service.AccountService;

@RestController
@RequestMapping({"/api"})
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(path = {"/create-account"})
	public ResponseEntity<Account> create(@RequestBody AccountDTO dto){
		if(dto.getRequest().isAcceptUser() && dto.getRequest().isAcceptSystem()) {
			Account account = dto.transformToAccount();
			account = accountService.create(account);
			
			
			return new ResponseEntity<>(account, HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(null, HttpStatus.OK);
		}	
		
	}
	
	@PutMapping(path = {"/transaction/{id}"})
	public ResponseEntity<Account> transaction(@PathVariable("id") long id, @RequestParam("description") String description,@RequestBody AccountTransactionDTO act) {
		Account account = accountService.transactionExtern(id, description, act);
		return new ResponseEntity<>(account, HttpStatus.OK);
		
	}

}
