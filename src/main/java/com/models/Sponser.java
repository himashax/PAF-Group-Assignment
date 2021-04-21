package com.models;

public class Sponser {
	private int id;         	//declare variables
	private int sponserID;  	//declare variables
	private int productId;		//declare variables
	private String fName;   	//declare variables
	private String lName;   	//declare variables
	private float amount;  		//declare variables
	private String companyName; //declare variables
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSponserID() {
		return sponserID;
	}
	public void setSponserID(int sponserID) {
		this.sponserID = sponserID;
	}
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}
