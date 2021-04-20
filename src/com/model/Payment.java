package com.model;

public class Payment {

	private int id;
	private int paymentID;
	private double amount;
	private String type;
	private int productID;
	private int customerID;

	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public int getPaymentID() {
	return paymentID;
	}
	public void setPaymentID(int paymentID) {
	this.paymentID = paymentID;
	}
	public double getAmount() {
	return amount;
	}
	public void setAmount(double amount) {
	this.amount = amount;
	}
	public String getType() {
	return type;
	}
	public void setType(String type) {
	this.type = type;
	}
	public int getProductID() {
	return productID;
	}
	public void setProductID(int productID) {
	this.productID = productID;
	}
	public int getCustomerID() {
	return customerID;
	}
	public void setCustomerID(int customerID) {
	this.customerID = customerID;
	}
}
