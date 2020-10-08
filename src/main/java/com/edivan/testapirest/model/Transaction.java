package com.edivan.testapirest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	
	private AccountTransaction targetAccount;
	private Account ownAccount;
	private String description;
	private Date dateTransaction;
	private boolean isExecuted;
	
	public Transaction() {
		super();
	}
	
	
	public Transaction(AccountTransaction targetAccount, Account ownAccount, String description,
			Date dateTransaction) {
		super();
		this.targetAccount = targetAccount;
		this.ownAccount = ownAccount;
		this.description = description;
		this.dateTransaction = dateTransaction;
	}


	public boolean isExecuted() {
		return isExecuted;
	}
	public void setExecuted(boolean isExecuted) {
		this.isExecuted = isExecuted;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public AccountTransaction getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(AccountTransaction targetAccount) {
		this.targetAccount = targetAccount;
	}
	public Account getOwnAccount() {
		return ownAccount;
	}
	public void setOwnAccount(Account ownAccount) {
		this.ownAccount = ownAccount;
	}
	
	
	
}
