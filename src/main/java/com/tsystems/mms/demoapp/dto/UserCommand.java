package com.tsystems.mms.demoapp.dto;


public class UserCommand {

	private String email;

	
	private String firstName;


	private String surname;

	private String gender;

	public UserCommand() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserCommand(String email, String firstName, String surname, String gender) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.surname = surname;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
