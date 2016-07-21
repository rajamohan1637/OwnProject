package com.examportal.dto;

public class UserLoginDTO {

	private String username;
	private String password;
	public boolean valid;
	private String fName;
	private String lName;

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
		return valid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void removeUserName() {
		this.password = null;
	}

	public void removePassword() {
		this.username = null;
	}
}
