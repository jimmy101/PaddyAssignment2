package com.login;

public class PurchasesBean {
	
	private int purchases_id, ammount;
	private String email, title, manufacturer;
	private float price;
	
	public PurchasesBean() {
		
	}

	public PurchasesBean(int purchases_id, String user_email, String title,
			String manufacturer, float price) {
		super();
		this.purchases_id = purchases_id;
		this.email = user_email;
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public int getPurchasesId() {
		return purchases_id;
	}

	public void setPurchasesId(int id) {
		this.purchases_id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public int getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(int purchases_id) {
		this.purchases_id = purchases_id;
	}
	
	
}
