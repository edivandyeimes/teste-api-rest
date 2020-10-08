package com.edivan.testapirest.dto;



import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.edivan.testapirest.model.Person;
import com.edivan.testapirest.validator.AgeIsOver;
import com.fasterxml.jackson.annotation.JsonFormat;



public class PersonDTO {
	
	@NotBlank(message = "Nome é obrigatório.")
	private String firstName;
	
	@NotBlank(message = "Sobrenome é obrigatório.")
	private String lastName;
	
	@Email(message = "Email  válido é obrigatório.")
	private String email;
	
	@CPF(message = "CPF válido é obrigatório.")
	private String cpf;
	
	@NotBlank(message = "Data é obrigatoria.")
	@AgeIsOver(message = "Necessário ser maior de 18 anos.")
	@JsonFormat(pattern="yyyy-MM-dd")
	private String birthDate;


	public PersonDTO(@NotBlank(message = "Nome é obrigatório.") String firstName,
			@NotBlank(message = "Sobrenome é obrigatório.") String lastName,
			@Email(message = "Email  válido é obrigatório.") String email,
			@CPF(message = "CPF válido é obrigatório.") String cpf,
			@NotBlank(message = "Data é obrigatoria.") @AgeIsOver(message = "Necessário ser maior de 18 anos.") String birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Person transformToObject() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(birthDate);
    	
    	
		return new Person(firstName, lastName, email, cpf, date);
	}
	
	
	
}
