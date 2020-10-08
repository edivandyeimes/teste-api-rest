package com.edivan.testapirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edivan.testapirest.dao.AdressRepository;
import com.edivan.testapirest.model.Adress;

@Service
public class AdressService {

	@Autowired
	private AdressRepository adressRepository;
	
	public Adress create(String cpf, Adress adress) {
				adress = adressRepository.save(adress);
				PersonService personService = new PersonService();
				boolean isAdd = personService.addAdress(cpf, adress.getId());
				if(isAdd) {
					return adress;
				}
				else {
					return null;
				}
	}
}
