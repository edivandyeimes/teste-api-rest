package com.edivan.testapirest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edivan.testapirest.dto.LoginDTO;
import com.edivan.testapirest.service.LoginService;

@RestController
@RequestMapping({"/api"})
public class LoginController {
	

	@Autowired
	private LoginService loginService;
	


	@PostMapping(path = {"/first-login"})
	public ResponseEntity<String> createToken(@RequestParam("email") String email, @RequestParam("cpf") String cpf) {
		
		if (loginService.createToken(email, cpf)) {
			
			return new ResponseEntity<>("Sucess sending email.", HttpStatus.OK);		
		}
		else {
			
			return new ResponseEntity<>("Error sending email.", HttpStatus.UNPROCESSABLE_ENTITY);
		}	
	}
	
		
	@PostMapping(path = {"/create-psw"})
	public ResponseEntity<String> createPassword(@RequestBody LoginDTO dto) {
		
		if(loginService.createPassword(dto.getCpf(), dto.getToken(), dto.getPassword())) {	
		
			return new ResponseEntity<>("Sucess", HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}

}
