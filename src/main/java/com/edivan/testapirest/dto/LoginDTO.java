package com.edivan.testapirest.dto;

import com.edivan.testapirest.validator.ValidPassword;

public class LoginDTO {

	private String email;
	private String cpf;
	
	@ValidPassword
	private String password;
	private long token;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getToken() {
		return token;
	}
	public void setToken(long token) {
		this.token = token;
	}
	
	
}
