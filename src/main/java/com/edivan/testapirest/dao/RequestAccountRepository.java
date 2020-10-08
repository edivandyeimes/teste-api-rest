package com.edivan.testapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edivan.testapirest.model.RequestAccount;

@Repository
public interface RequestAccountRepository extends JpaRepository<RequestAccount, Long> {
	
	
	@Query("SELECT * FROM #{#entityName} WHERE id = ?1")
	RequestAccount findById(long id);
	
	@Query("UPDATE #{#entityName} SET isacceptuser = true WHERE id = ?1")
	RequestAccount addConfirmUser(long id);
	
}
