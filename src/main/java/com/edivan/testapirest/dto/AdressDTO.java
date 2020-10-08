package com.edivan.testapirest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edivan.testapirest.model.Adress;
import com.edivan.testapirest.model.Person;

public class AdressDTO {
	
	@NotNull
	private Person person;
	
	@NotBlank
	private String street;
	
	@NotBlank
	@Pattern(regexp = "\\d{5}-\\d{3}")
	private String code;
	
	@NotBlank
	private String complement;
	
	@NotBlank
	private String district;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;

	public AdressDTO(@NotNull Person person, @NotBlank String street, @NotBlank String code,
			@NotBlank String complement, @NotBlank String district, @NotBlank String city, @NotBlank String state) {
		super();
		this.person = person;
		this.street = street;
		this.code = code;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Adress transformToObject() {
		return new Adress(person, street, code, complement, district, city, state);
	}
	
	
}
