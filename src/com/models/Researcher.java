package com.models;

public class Researcher {

	private int researcherID;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private int product;
	
	public int getResearcherID() {
		return researcherID;
	}
	public void setResearcherID(int researcherID) {
		this.researcherID = researcherID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	
	
}