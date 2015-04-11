package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Success extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	private String name,address1,address2,address3,email,username,password;
	private int id;
	private ArrayList<User>userList;
	
	
	

	public Success() {
		
	}




	public String execute() {
	      String ret = ERROR;
	      Connection conn1 = null;
	  userList  =  new ArrayList<User>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddy";
				Class.forName("com.mysql.jdbc.Driver");
				conn1 = DriverManager.getConnection(URL, "root", "root");
				
				Statement st1 = conn1.createStatement(); 
				ResultSet rs1 = st1.executeQuery("select * from user ");
				
				
			     User ve = null;
			   
				while (rs1.next()) {
					  ve = new User();
					
					ve.setId(rs1.getInt(1));
					ve.setName(rs1.getString(2));
					ve.setAddress1(rs1.getString(3));
					ve.setAddress2(rs1.getString(4));
					ve.setAddress3(rs1.getString(5));
					ve.setEmail(rs1.getString(6));
					ve.setUserName(rs1.getString(7));
					ve.setPassword(rs1.getString(8));
					userList.add(ve);
					
					}
			
					
					
				
				return SUCCESS;
	      }
			 catch (Exception e) {
				ret = ERROR;
			} finally {
				if (conn1 != null) {
					try {
						conn1.close();
					} catch (Exception e) {
					}
				}
			}
		
			return ret;
		}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
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




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public ArrayList<User> getUserList() {
		return userList;
	}




	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
}
