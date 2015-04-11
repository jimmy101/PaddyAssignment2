package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class GetCustomerListAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 6446985129361884948L;
	private int id;
	private String name;
	private ArrayList<User> userList;

	public String execute(){
		 String ret = ERROR;
	      Connection conn1 = null;
	  userList  =  new ArrayList<User>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddy";
				Class.forName("com.mysql.jdbc.Driver");
				conn1 = DriverManager.getConnection(URL, "root", "root");
				
				Statement st1 = conn1.createStatement(); 
				ResultSet rs1 = st1.executeQuery("select * from user where id = ? and name = ?");
				
				
			     User ve = null;
				while (rs1.next()) {
					ve = new User();
					ve.setId(rs1.getInt(1));
					ve.setName(rs1.getString(2));
					
									
					userList.add(ve);
					
					
				}
				return SUCCESS;
				
			} catch (Exception e) {
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

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	

}
