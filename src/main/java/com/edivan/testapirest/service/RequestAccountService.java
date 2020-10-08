package com.edivan.testapirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edivan.testapirest.dao.RequestAccountRepository;
import com.edivan.testapirest.model.Person;
import com.edivan.testapirest.model.RequestAccount;

@Service
public class RequestAccountService {

	@Autowired
	RequestAccountRepository requestAccountRepository;
	
	public long create(Person person) {
		
			RequestAccount rac = new RequestAccount(person, null, null, false, false);
			rac = requestAccountRepository.save(rac);
			
			return rac.getId();
		}
	
	public RequestAccount confirmInformation(long id) {
			RequestAccount rac =  requestAccountRepository.addConfirmUser(id);
			return rac;
		
	}
	
	public RequestAccount findById(long id) {
		return requestAccountRepository.findById(id);
	}

}
