package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.Session;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class FinalCheckout extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Item> itemList;
	private ArrayList<Double> fianTotal;
	ArrayList<PurchasesBean> purchasesList;
	private ArrayList<User> userList;
	private String email,title,manufacturer,category,address1,address2,address3;
	private int purchases_id, id,ammount,quantity;
	private float price;	
	private String email2;
	private double total= 0.0 ;

	public String execute() {
		String ret = ERROR;
		Connection conn1 = null;
		itemList =  new ArrayList<Item>();
		purchasesList = new ArrayList<PurchasesBean>();
		userList = new ArrayList<User>();
		fianTotal = new ArrayList<Double>();

		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(URL, "root", "root");

			Statement st = conn1.createStatement(); 
			ResultSet rs = st.executeQuery("select * from purchases  ");

			PurchasesBean ve = null;
			while (rs.next()) {
				ve = new PurchasesBean();
				ve.setPurchases_id(rs.getInt(1));
				ve.setTitle(rs.getString(2));
				ve.setManufacturer(rs.getString(3));
				ve.setPrice(rs.getFloat(4));
				ve.setAmmount(rs.getInt(5));

				purchasesList.add(ve);

			}
			double sum1;
			for(PurchasesBean sub:purchasesList){
				sum1 =sub.getAmmount();
				System.out.println("amount"+sum1);
				sum1 = sub.getPrice()*sub.getAmmount();
				System.out.println("amount"+sum1);
				total = total + sum1;
				
			}
			  fianTotal.add(total);
			
			
			System.out.println("DASDASADASDAS"+total);

			Statement st1 = conn1.createStatement(); 
			ResultSet rs1 = st1.executeQuery("select email from email ");
			while (rs1.next()){
				email2 = rs1.getString(1);
				System.out.println(rs1.getString(1)+"QQQQQQQQQQQQQQQQQQQQQ");

			}

			PreparedStatement ps = conn1.prepareStatement("SELECT * from user WHERE email = ? ");
			System.out.println("ASDASDASDASSD"+getEmail2());
			ps.setString(1, getEmail2());		                 
			ResultSet rs12 = ps.executeQuery();

			while (rs12.next()){
				System.out.println(rs12.getString(1)+"QQQQQQQQQQQQQQQQQQQQQ");
				User user = new User();

				user.setName(rs12.getString(2));
				user.setAddress1(rs12.getString(3));
				user.setAddress2(rs12.getString(4));
				user.setAddress3(rs12.getString(5));
				userList.add(user);
			}



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


	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}


	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
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

	public int getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(int purchases_id) {
		this.purchases_id = purchases_id;
	}


	public ArrayList<User> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
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


	public ArrayList<Double> getFianTotal() {
		return fianTotal;
	}


	public void setFianTotal(ArrayList<Double> fianTotal) {
		this.fianTotal = fianTotal;
	}

	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
}
