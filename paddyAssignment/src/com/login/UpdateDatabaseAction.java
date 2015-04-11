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
	private String title,userName,test1,email ;
	private String manufacturer,time;
	private int quantity,purchases_id,item_id,id;
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
			
			Statement st11 = conn1.createStatement(); 
			ResultSet rs11 = st11.executeQuery("select * from email");
			while(rs11.next()){
				//System.out.println("DSDSDSDSDSDS"+rs11.getString(1));
				setEmail(rs11.getString(1));
				
			}
			
			
			PreparedStatement ps221=conn1.prepareStatement("select * from user where email = ?");
			ps221.setString(1, getEmail());
			ResultSet rs12 = ps221.executeQuery();
			while(rs12.next()){
				System.out.println("AAAAAAAAAAAA"+rs12.getString(2));
				setUserName(rs12.getString(7));
			}
				
				System.out.println("BBBBBBBBBBBBBBBBBBBBBBBB"+getUserName());
					
			
			Statement st1 = conn1.createStatement(); 
			ResultSet rs = st1.executeQuery("select * from purchases");
			
			
			PreparedStatement ps=conn1.prepareStatement("insert into history values(?,?,?,?,?,?,?,?,?)");
			while (rs.next()) {
			ps.setInt(1, getItem_id());
			ps.setInt(2, rs.getInt(1));
			ps.setString(3,rs.getString(2));
			ps.setString(4,rs.getString(3));			  			
			ps.setFloat(5,rs.getFloat(4));
			ps.setInt(6,rs.getInt(5));				
			ps.setString(7, getTime());
			ps.setInt(8, getId());
			ps.setString(9, getName());
			
			ps.executeUpdate();
			
			}
			
			while (rs.next()){
			    System.out.println("jimmyjimmyjimmyjimmy"+rs.getString(1));						
				PurchasesBean ve = new PurchasesBean();
				ve.setPurchases_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));				
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				ve.setAmmount(rs.getInt(5));
				purchasesList.add(ve);
			}
			
			setTotal();
				
				
				
				
			
			PreparedStatement ps2=conn1.prepareStatement("Delete from purchases where purchases_id >= 0");
			ps2.executeUpdate();
			
				
			
			
				
			
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

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
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

	
	
	

}
