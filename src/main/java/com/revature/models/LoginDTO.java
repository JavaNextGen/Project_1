package com.revature.models;


public class LoginDTO {

	//our LoginDTO models ONLY the username/password of our users
	private String username;
	private String password;


	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	

	//toString just incase we want to print out the object (could be helpful for debug)
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
