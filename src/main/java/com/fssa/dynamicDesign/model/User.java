package com.fssa.dynamicDesign.model;

public class User {
	
	private int userId;
	private String email;
	private String username;
	private String password;
	private String phonenumber;
	private String type;
	private boolean isDeleted;
	
	
	public User(int userId, String email, String username, String password, String phonenumber, String type,
			boolean isDeleted) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.type = type;
		this.isDeleted = isDeleted;
	} 


	
	public User(int userId, String email, String username, String password, String phonenumber, String type) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.type = type;
	}



	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public User(String email, boolean isDeleted) {
		super();
		this.email = email;
		this.isDeleted = isDeleted;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	

}