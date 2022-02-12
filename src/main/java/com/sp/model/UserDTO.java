package com.sp.model;

public class UserDTO {
	
	private String login;
	private String pwd;
	private String account;
	private String surName;
	private String lastName;
	
	public UserDTO() {
		this.login = "";
		this.pwd = "";
		this.account = "";
		this.surName = "";
		this.lastName = "";
	}
	
	public UserDTO(String login, String pwd, String account, String surName, String lastName) {
		this.login = login;
		this.pwd = pwd;
		this.account = account;
		this.surName = surName;
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
