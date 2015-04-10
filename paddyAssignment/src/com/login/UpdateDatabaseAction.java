package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateDatabaseAction extends ActionSupport{

	
	private static final long serialVersionUID = -453350948722456448L;
	private String title ;
	private String manufacturer,time;
	private int quantity,purchases_id,item_id;
	private float price;
	private ArrayList<PurchasesBean> purchasesList;
	private double total = 0.0;
	private ArrayList<Double> fianTotal;
	
	public String execute() {
		
		purchasesList = new ArrayList<PurchasesBean>();
		fianTotal = new ArrayList<Double>();
		String ret = ERROR;
		Connection conn1 = null;
		
		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
		
			conn1 = DriverManager.getConnection(URL, "root", "root");
					
			
			Statement st1 = conn1.createStatement(); 
			ResultSet rs = st1.executeQuery("select * from purchases");
			
			while (rs.next()){
			    System.out.println("jimmyjimmyjimmyjimmy"+rs.getString(1));						
				String num = rs.getString(1);
				PurchasesBean ve = new PurchasesBean();
				ve.setPurchases_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));				
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				ve.setAmmount(rs.getInt(5));
				purchasesList.add(ve);
				
			}
			setTotal();
				PreparedStatement ps=conn1.prepareStatement("insert into history values(?,?,?,?,?,?,?)");
				while (rs.next()) {
				ps.setInt(1, getItem_id());
				ps.setInt(2, rs.getInt(1));
				ps.setString(3,rs.getString(2));
				ps.setString(4,rs.getString(3));			  			
				ps.setFloat(5,rs.getFloat(4));
				ps.setInt(6,rs.getInt(5));
				ps.setString(7, getTime());
				ps.executeUpdate();
			
				
				}
			
			//PreparedStatement ps2=conn1.prepareStatement("Delete from purchases where purchases_id >= 0");
			//ps2.executeUpdate();
			
				
			
			
				
			
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
	
	public void setTotal(){
		
		double sum1;
		for(PurchasesBean sub:purchasesList){			
			sum1 = sub.getPrice()*sub.getAmmount();			
			 total = total + sum1;			 
		}
		fianTotal.add(total);
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

	public int getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(int purchases_id) {
		this.purchases_id = purchases_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<Double> getFianTotal() {
		return fianTotal;
	}

	public void setFianTotal(ArrayList<Double> fianTotal) {
		this.fianTotal = fianTotal;
	}
	
	

}
