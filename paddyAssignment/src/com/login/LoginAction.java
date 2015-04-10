package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   private String user;
	   private String password;
	   private String name,email;
	   private String userName;
	   private HttpSession session;
	   private HttpServletRequest session1;
	private String address1;
	private String address2;
	private String address3;
	private int id;
	   

	public String execute()throws Exception {
		 session = session1.getSession();
		 String ret = ERROR;
	      Connection conn = null;
	     
	     

	      try {
	        
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paddy","root", "root");
	         
	        
	        
	         
	         PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE userName = ? AND password = ?");
	         ps.setString(1, userName);
	         ps.setString(2, password);	         
	         ResultSet rs = ps.executeQuery();
	       
	         

	         while (rs.next()) {
	        	 name = rs.getString(2);
	        	 email =rs.getString(3);
	        	 address1=rs.getNString(4);
	        	 address2=rs.getNString(5);
	        	 address3=rs.getNString(6);
	        	
	        	
	 	         PreparedStatement ps1=conn.prepareStatement("insert into email values(?)");
	 	         ps1.setString(1, rs.getString(6));
	 	 	     ps1.executeUpdate();
	 	 	     
	 	 	  
	 	 	     
	        	 User user = new User(id,name,address1,address2, address3, email, userName,password);
	        	 session.setAttribute("user", user);
	             if(name.equalsIgnoreCase("Frank Doyle")){
	             	return  "success1";
	             }else
	             ret = SUCCESS;
	         } 
	         
	      } catch (Exception e) {
	         ret = ERROR;
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return ret;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	@Override
	public void setServletRequest(HttpServletRequest session1) {
		this.session1 = session1;
		
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletRequest getSession1() {
		return session1;
	}

	public void setSession1(HttpServletRequest session1) {
		this.session1 = session1;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	 
}
