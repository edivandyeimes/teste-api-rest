package com.edivan.testapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edivan.testapirest.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long>{
	
	@Query("SELECT * FROM #{#entityName} WHERE value = ?1")
	Token findByValue(long token);
	
}
