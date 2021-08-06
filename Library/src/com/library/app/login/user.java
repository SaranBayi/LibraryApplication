package com.library.app.login;

public class user {
	private int id;
	private String UserName;
	private int PHNumber;
	private String EMAIL;
	private String Password;
	private String Role;

	public user(int id, String userName, int pHNumber, String eMAIL, String password, String role) {
		super();
		this.id = id;
		this.UserName = userName;
		this.PHNumber = pHNumber;
		this.EMAIL = eMAIL;
		this.Password = password;
		this.Role = role;
	}

	public user() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public int getPHNumber() {
		return PHNumber;
	}

	public void setPHNumber(int pHNumber) {
		this.PHNumber = pHNumber;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		this.EMAIL = eMAIL;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		this.Role = role;
	}

}
