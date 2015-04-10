package com.login;

public class Item {
	
	private int item_id, quantity;
	private String title,manufacturer,category,image;
	private float price;
	
	public Item() {
		
	}
	
	

	public Item(int item_id, int quantity, String title, String manufacturer,
			String category, String image, float price) {
		super();
		this.item_id = item_id;
		this.quantity = quantity;
		this.title = title;
		this.manufacturer = manufacturer;
		this.category = category;
		this.image = image;
		this.price = price;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	

}
