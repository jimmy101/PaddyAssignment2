package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import com.opensymphony.xwork2.ActionSupport;

public class UpdateStockAction extends ActionSupport{
	
	private String title,manufacturer,image,category;
	private int item_id,quantity;
	private float price;
	private static final long serialVersionUID = 1L;
	
	
	

	public UpdateStockAction() {
		
	}

	public String execute() {
		String ret = ERROR;
		Connection conn1 = null;
		
		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
		
			conn1 = DriverManager.getConnection(URL, "root", "root");
			
			PreparedStatement ps=conn1.prepareStatement("insert into item values(?,?,?,?,?,?,?)");  
			ps.setInt(1,getItem_id());
			ps.setString(2,getTitle());  
			ps.setString(3,getManufacturer());
			ps.setFloat(4,getPrice());
			ps.setString(5,getCategory());
			ps.setString(6,getImage());
			ps.setInt(7,getQuantity());
			
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
