package com.edivan.testapirest.controller;


import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edivan.testapirest.dto.PersonDTO;
import com.edivan.testapirest.model.Person;
import com.edivan.testapirest.service.PersonService;

@RestController
@RequestMapping({"/api"})
public class PersonController {
	
	@Autowired
	private PersonService personService;

		
	
	@PostMapping(path = {"/person"})
	public ResponseEntity<Person> create(@RequestBody @Valid PersonDTO dto) throws ParseException {
		Person person =dto.transformToObject();
		person = personService.create(person);
		
		if(person != null) {
			return new ResponseEntity<>(person, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
