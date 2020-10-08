package com.edivan.testapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edivan.testapirest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query("SELECT * FROM #{#entityName} WHERE cpf LIKE ?1")
	Person findByCpf(String cpf);
	
	Person findById(long id);
	
	@Query("UPDATE #{#entityName} SET adressId = ?2 WHERE cpf LIKE ?1")
	Person addAdress(String cpf, long adressId);
	
	@Query("UPDATE #{#entityName} SET password = ?2 WHERE cpf LIKE ?1")
	Person savePassword(String cpf, String pswEncrypted);
}
