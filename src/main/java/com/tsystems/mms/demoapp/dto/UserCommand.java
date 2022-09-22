package com.tsystems.mms.demoapp.dto;

public class UserCommand {

	private String email;

	public UserCommand(String email) {
		this.email = email;
	}

	public UserCommand() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
