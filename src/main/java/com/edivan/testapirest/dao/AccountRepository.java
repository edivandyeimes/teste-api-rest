package com.edivan.testapirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edivan.testapirest.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findById(long id);

	@Query("UPDATE accounts SET balance = ?2 WHERE id = ?1")
	Account updateBalance(long id, double balance);
}
