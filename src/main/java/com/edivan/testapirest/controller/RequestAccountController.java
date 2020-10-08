package com.edivan.testapirest.controller;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.edivan.testapirest.model.RequestAccount;
import com.edivan.testapirest.service.RequestAccountService;

@RestController
@RequestMapping({"/api"})
public class RequestAccountController {

	@Autowired
	RequestAccountService requestAccountService;
	

	@GetMapping(path = {"/check-information/{id}"})
	public ResponseEntity<RequestAccount> checkInformation(@PathParam("id") long id){
		RequestAccount rac = requestAccountService.findById(id);
		
		
		return new ResponseEntity<>(rac, HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/confirm-information/{id}"})
	public ResponseEntity<String> confirmInformation(@PathParam("id") long id, @RequestParam("isAccept") boolean isAccept){
		RequestAccount rac = requestAccountService.findById(id);
		if(isAccept) {
			if(rac.getId() != 0 && rac.getFileOne() != null && rac.getFileTwo() != null && rac.getPerson() != null && rac.getPerson().getAdress() != null) {
				rac =  requestAccountService.confirmInformation(id);
				return new ResponseEntity<>("Create new account", HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>("Incomplete steps", HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		else {
			if(rac.getId() != 0 && rac.getFileOne() != null && rac.getFileTwo() != null && rac.getPerson() != null && rac.getPerson().getAdress() != null) {
				return new ResponseEntity<>("Not accept by the user", HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>("Incomplete steps", HttpStatus.UNPROCESSABLE_ENTITY);
			}
	
		}
		
	}
	
}
