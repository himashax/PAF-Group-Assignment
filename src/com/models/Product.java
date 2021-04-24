package com.models;

import java.sql.Date;

/**
 * @author sgeet
 *
 */
/**
 * @author sgeet
 *
 */
public class Product {

	//declare the variables
	private int id;
	private int productId;
	private String name;
	private Date date;
	private double price;
	private String resId;
	
	
	//get ID
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	//set ID 
	public void setId(int id) {
		this.id = id;
	}
	
	//get product name
	public String getName() {
		return name;
	}
	
	//set product name
	public void setName(String name) {
		this.name = name;
	}
	
	//get date
	public Date getDate() {
		return date;
	}
	
	//set the date
	public void setDate(Date date) {
		this.date = date;
	}
	
	//get price as double value
	public double getPrice() {
		return price;
	}
	
	//set the price
	public void setPrice(double price) {
		this.price = price;
	}
	
	//get the product id
	public int getProductId() {
		return productId;
	}
	
	//set the product id
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//get res id as a String
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	
	//display the product in String format
	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", date=" + date + ", price="
				+ price + "]";
	}
}
