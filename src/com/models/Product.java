package com.models;

import java.sql.Date;

public class Product {

	private int id;
	private int productId;
	private String name;
	private Date date;
	private double price;
	private String resId;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", date=" + date + ", price="
				+ price + "]";
	}
}
