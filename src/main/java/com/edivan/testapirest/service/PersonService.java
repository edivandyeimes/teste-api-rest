package com.edivan.testapirest.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.edivan.testapirest.dao.PersonRepository;
import com.edivan.testapirest.model.Person;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	
	
	public Person create(Person person) {
		person = personRepository.save(person);
		RequestAccountService rac = new RequestAccountService();
		long requestId = rac.create(person);
		
		if(requestId != 0) {
			return person;
		}
		else {
			return person;
		}
		
	}
	
	public Person findByCpf(String cpf) {
		
		return personRepository.findByCpf(cpf);
		
	}
	
	public Person savePassword(String cpf, String psw) {
		PasswordEncoder passwordEncoder = null;
		String pswEncrypted = passwordEncoder.encode(psw);
		Person person = personRepository.savePassword(cpf, pswEncrypted);
		
		return person;
	}
	
	public boolean addAdress(String cpf, long adressId) {
		Person person = personRepository.addAdress(cpf, adressId);
		
		if(person != null) {
			
			return true;
		}
		else {
			return false;
		}
		
	}
}
