package com.tsystems.mms.demoapp.dto;


public class UserDto {
	

	protected Long id;

	private String email;

	private String firstName;

	private String surname;

	private String gender;
	
	private String organisationUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getOrganisationUnit() {
		return organisationUnit;
	}

	public void setOrganisationUnit(String organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

	public UserDto(Long id, String email, String firstName, String surname, String gender, String organisationUnit) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.surname = surname;
		this.gender = gender;
		this.organisationUnit = organisationUnit;
	}

	public UserDto() {
		super();
	}
	
	


	
	
	
	
	
	
	

}
