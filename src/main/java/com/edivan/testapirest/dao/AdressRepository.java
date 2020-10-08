package com.edivan.testapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edivan.testapirest.model.Adress;
import com.edivan.testapirest.model.Person;



@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

	Adress findByPerson(Person person);
	Adress findById(long id);
}
