package com.edivan.testapirest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@OneToOne
	private Person person;
	
	private long value;
	private Date criationDate;
	private Date expirationDate;
	
	
	
	public Token(Person person, long value, Date criationDate, Date expirationDate) {
		super();
		this.value = value;
		this.criationDate = criationDate;
		this.expirationDate = expirationDate;
	}
	public long getId() {
		return id;
	}
	public long getValue() {
		return value;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public Date getCriationDate() {
		return criationDate;
	}
	public void setCriationDate(Date criationDate) {
		this.criationDate = criationDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
}
