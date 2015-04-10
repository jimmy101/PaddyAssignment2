package com.login;


public class User {
	private String name, address1,address2,address3;
	private String email;
	private String userName;
	private String password;
	private int id;
	
	public User() {
		
	}

	public User(int id,String name, String address1, String address2, String address3,
			String email, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.userName = userName;
		this.password = password;
		
	}









	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}






	public String getAddress1() {
		return address1;
	}






	public void setAddress1(String address1) {
		this.address1 = address1;
	}






	public String getAddress2() {
		return address2;
	}






	public void setAddress2(String address2) {
		this.address2 = address2;
	}






	public String getAddress3() {
		return address3;
	}






	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	

}

