package com.edivan.testapirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.edivan.testapirest.dto.AdressDTO;
import com.edivan.testapirest.model.Adress;
import com.edivan.testapirest.service.AdressService;

@RestController
@RequestMapping({"/api"})
public class AdressController {
	
	@Autowired
	AdressService adressService;

	
	@PutMapping(path = {"/adress/{cpf}"})
	public ResponseEntity<Adress> create(@RequestParam("cpf") String cpf, @RequestBody @Valid AdressDTO dto) {
		Adress adress = dto.transformToObject();
		adress = adressService.create(cpf, adress);
		if(adress != null) {
			return new ResponseEntity<>(adress, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
