package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class RegisterDao {
	public static int save(RegisterAction r){  
		int status = 0;  
		try {  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/paddy","root","root"); 
		
		
		  
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?)");  
	
		ps.setInt(1,r.getId());
		ps.setString(2,r.getName());  
		ps.setString(3,r.getAddress1());
		ps.setString(4,r.getAddress2());
		ps.setString(5,r.getAddress3());
		ps.setString(6,r.getEmail());
		ps.setString(7,r.getUserName());
		ps.setString(8,r.getPassword());
		status=ps.executeUpdate(); 
		
		
		
		
		  
		} catch(Exception e){e.printStackTrace();
		}  
		    return status;  
		}  

}
