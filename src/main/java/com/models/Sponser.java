package com.models;

public class Sponser {
	private int id;         	//declare variables
	private int sponserID;  	//declare variables
	private int productId;		//declare variables
	private String fName;   	//declare variables
	private String lName;   	//declare variables
	private float amount;  		//declare variables
	private String companyName; //declare variables
	
	//return the id
	public int getId() {
		return id;
	}
	
	//set value to id
	public void setId(int id) {
		this.id = id;
	}
	
	//return the sponserID
	public int getSponserID() {
		return sponserID;
	}
	
	//set id to the sponserID
	public void setSponserID(int sponserID) {
		this.sponserID = sponserID;
	}
	
	//return the product id
	public int getProductId() {
		return productId;
	}
	
	//set value to productId
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//get the first name of the sponsor
	public String getfName() {
		return fName;
	}
	
	//set first name for sponsor
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	//get the last name of the sponsor
	public String getlName() {
		return lName;
	}
	
	//set last name for sponsor
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	//return the amount of sponsorship
	public float getAmount() {
		return amount;
	}
	
	//set amount for sponsor
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	//get the company name of the sponsor
	public String getCompanyName() {
		return companyName;
	}
	
	//set company name for sponsor
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}
