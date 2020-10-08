package com.edivan.testapirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests_account")
public class RequestAccount implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@OneToOne
	private Person person;
	
	@OneToOne
	private File fileOne;
	
	@OneToOne
	private File fileTwo;
	private boolean isAcceptUser;
	private boolean isAcceptSystem;
	
	
	
	public RequestAccount(Person person, File fileOne, File fileTwo, boolean isAcceptUser, boolean isAcceptSystem) {
		super();
		this.person = person;
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
		this.isAcceptUser = isAcceptUser;
		this.isAcceptSystem = isAcceptSystem;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public File getFileOne() {
		return fileOne;
	}
	public void setFileOne(File fileOne) {
		this.fileOne = fileOne;
	}
	public File getFileTwo() {
		return fileTwo;
	}
	public void setFileTwo(File fileTwo) {
		this.fileTwo = fileTwo;
	}
	public boolean isAcceptUser() {
		return isAcceptUser;
	}
	public void setAcceptUser(boolean isAcceptUser) {
		this.isAcceptUser = isAcceptUser;
	}
	public boolean isAcceptSystem() {
		return isAcceptSystem;
	}
	public void setAcceptSystem(boolean isAcceptSystem) {
		this.isAcceptSystem = isAcceptSystem;
	}
	
	
}
