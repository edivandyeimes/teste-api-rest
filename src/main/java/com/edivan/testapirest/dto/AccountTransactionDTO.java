package com.edivan.testapirest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.br.CPF;

import com.edivan.testapirest.model.AccountTransaction;

public class AccountTransactionDTO {
	
	private long id;
	
	@NotBlank(message="Agência é obrigatória")
	@Digits(fraction = 0, integer = 4, message="Agência deve ter 4 dígitos")
	private int agency;
	
	@NotBlank(message="Conta é obrigatória")
	private int code;
	
	@NotBlank(message="Banco é obrigatório")
	private int bank;
	
	@NotBlank(message="Valor é obrigatório")
	@Positive(message="Valor deve ser positivo")
	private double value;
	
	@NotBlank(message="Nome é obrigatório")
	private String name;
	
	@NotBlank(message="CPF é obrigatório")
	@CPF(message="Valor é obrigatório")
	private String cpf;
	
	@NotBlank(message="Tipo de conta é obrigatório")
	private String type;
	
	private boolean favorite;
	
	

	public AccountTransactionDTO(
			int agency,
			int code, @NotBlank(message = "Banco é obrigatório") int bank,
			double value,
			String name,
			String cpf,
			String type, boolean favorite) {
		super();
		this.agency = agency;
		this.code = code;
		this.bank = bank;
		this.value = value;
		this.name = name;
		this.cpf = cpf;
		this.type = type;
		this.favorite = favorite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public AccountTransaction transformToAct() {
		
		return new AccountTransaction(this.agency, this.code, this.bank, this.value, this.name, this.cpf, this.type, this.favorite);
	}

	
	
}
