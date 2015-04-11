package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateMasterStockAction extends ActionSupport{

	
	private static final long serialVersionUID = 1762999253950684305L;
	private int item_id,newamount;

	public String execute() {
		String ret = ERROR;
		Connection conn1 = null;
		
		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
		
			conn1 = DriverManager.getConnection(URL, "root", "root");
			
			PreparedStatement ps=conn1.prepareStatement("update item set quantity = (quantity+ ?) where item_id =?");
			ps.setInt(1,getNewamount());
			ps.setInt(2,getItem_id());									
			ps.executeUpdate();
			
			
				ret = SUCCESS;
			
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

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getNewamount() {
		return newamount;
	}

	public void setNewamount(int newamount) {
		this.newamount = newamount;
	}
	
	
}
	
	
