package com.edivan.testapirest.dto;

import java.util.Random;

import javax.validation.constraints.NotNull;

import com.edivan.testapirest.model.Account;
import com.edivan.testapirest.model.Person;
import com.edivan.testapirest.model.RequestAccount;

public class AccountDTO {

	@NotNull
	private RequestAccount request;
	@NotNull
	private Person person;
	private int agency;
	private int code;
	private int bank;
	private double balance;
	
	

	public AccountDTO(RequestAccount request, Person person, int agency, int code, int bank, double balance) {
		super();
		this.request = request;
		this.person = person;
		this.agency = agency;
		this.code = code;
		this.bank = bank;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public RequestAccount getRequest() {
		return request;
	}
	public void setRequest(RequestAccount request) {
		this.request = request;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}
	
	public Account transformToAccount() {
		Random rand = new Random(); 
		
		return new Account(this.request, this.person, rand.nextInt(10000), rand.nextInt(100000000), 341, 0);
	}
	
}
