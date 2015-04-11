package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class AddToBasket extends ActionSupport{

	ArrayList<Item> itemList;
	ArrayList<PurchasesBean> purchasesList;
	private static final long serialVersionUID = 1L;
	private String email,title,manufacturer,category;
	private int purchases_id, item_id,id,ammount,quantity;
	public ArrayList<PurchasesBean> getPurchasesList() {
		return purchasesList;
	}

	public void setPurchasesList(ArrayList<PurchasesBean> purchasesList) {
		this.purchasesList = purchasesList;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	private float price;
	private int num;

	public String execute() {
		setQuantity(23);

		String ret = ERROR;
		Connection conn1 = null;
		itemList =  new ArrayList<Item>();
		purchasesList = new ArrayList<PurchasesBean>();

		try {
			String URL = "jdbc:mysql://localhost/paddy";
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection(URL, "root", "root");


			String sql = "SELECT * FROM item WHERE";
			sql+=" item_id = ? " ;
			PreparedStatement ps1 = conn1.prepareStatement(sql);
			ps1.setInt(1, getId());	        	 	         
			ResultSet rs1 = ps1.executeQuery();

			Item ve = null;
			while (rs1.next()) {

				System.out.println(rs1.getInt(1)+"ddddddddddddddddddddddddddddddd");

				ve = new Item();
				ve.setItem_id(rs1.getInt(1));
				ve.setTitle(rs1.getString(2));
				ve.setManufacturer(rs1.getString(3));
				ve.setPrice(rs1.getFloat(4));
				//ve.setQuantity(rs1.getInt(7));


				itemList.add(ve);

				PreparedStatement ps=conn1.prepareStatement("insert into purchases values(?,?,?,?,?)"); 
				ps.setInt(1, getPurchases_id());
				ps.setString(2, rs1.getString(2));				
				ps.setString(3 , rs1.getString(3));
				ps.setFloat(4 , rs1.getFloat(4));
				ps.setInt(5 , getAmmount());

				ps.executeUpdate();

				PurchasesBean purchases =  new PurchasesBean();
				purchases.setTitle(rs1.getString(2));
				purchases.setManufacturer(rs1.getString(3));
				purchases.setPrice(rs1.getFloat(4));
				purchases.setAmmount(getAmmount());
				purchasesList.add(purchases);

				PreparedStatement ps11=conn1.prepareStatement("insert into itemnumber values(?,?)");
				ps11.setInt(1, rs1.getInt(1));
				ps11.setInt(2, rs1.getInt(7));												
				ps11.executeUpdate();


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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private int getItem_id() {

		return item_id;
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
}
