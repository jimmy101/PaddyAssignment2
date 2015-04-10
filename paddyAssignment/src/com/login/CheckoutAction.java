package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




import com.opensymphony.xwork2.ActionSupport;

public class CheckoutAction extends ActionSupport {
	
	ArrayList<Item> itemList;
	private static final long serialVersionUID = 1L;
	private String email,title,manufacturer,category;
	private int id,ammount,quantity;
	private float price;
	

	public String execute() {
		
		
	
		String ret = ERROR;
		Connection conn1 = null;
		itemList =  new ArrayList<Item>();

		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(URL, "root", "root");
			Statement st = conn1.createStatement(); 
			
			 PreparedStatement ps = conn1.prepareStatement("select * FROM item WHERE item_id = ?");
		       ps.setInt(1,getId());		       
		       ResultSet rs = ps.executeQuery();	
		     Item ve = null;
		   
			while (rs.next()) {
				  ve = new Item();
				ve.setItem_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				ve.setCategory(rs.getString(5));
				ve.setImage(rs.getString(6));
				ve.setQuantity(rs.getInt(7));
				if(ve.getQuantity()> getAmmount()){
				
					itemList.add(ve);
					
					
				}if(ve.getQuantity()< getAmmount()){
					int amo = this.getId();
					this.setId(amo);
					
					itemList.add(ve);
					
					return "success2";
					}
				
				
				
	         
	         
			
			System.out.println(getQuantity()+"dddddddddddddddddddd");
			
			
			
				
				
				
				ret = SUCCESS;
		
			}
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

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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


	


}
