package com.edivan.testapirest.dto;

import com.edivan.testapirest.model.File;
import com.edivan.testapirest.model.Person;
import com.edivan.testapirest.model.RequestAccount;

public class RequestAccountDTO {
	
	private Person person;
	private File fileFront;
	private File fileBack;
	private boolean isAcceptUser;
	private boolean isAcceptSystem;
	
	
	
	public RequestAccountDTO(Person person, File fileFront, File fileBack, boolean isAcceptUser,
			boolean isAcceptSystem) {
		super();
		this.person = person;
		this.fileFront = fileFront;
		this.fileBack = fileBack;
		this.isAcceptUser = isAcceptUser;
		this.isAcceptSystem = isAcceptSystem;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public File getFileFront() {
		return fileFront;
	}
	public void setFileFront(File fileFront) {
		this.fileFront = fileFront;
	}
	public File getFileBack() {
		return fileBack;
	}
	public void setFileBack(File fileBack) {
		this.fileBack = fileBack;
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
	
	public RequestAccount transformRequestOne() {
		
		return new RequestAccount(this.person, this.fileFront, this.fileBack, this.isAcceptUser, this.isAcceptSystem);
	}
}
