package com.pafproject.customerApiProject;

public class Customer {

	
	
	public int id;
	public String name;                ///declare the variables
	public String address;
	public int phoneno;
	public String email;
	public String occupation;
	public String needproduct;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;													//get setters and getters
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phoneno=" + phoneno + ", email="
				+ email + ", occupation=" + occupation + ", needproduct=" + needproduct + "]";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getNeedproduct() {
		return needproduct;
	}
	public void setNeedproduct(String needproduct) {
		this.needproduct = needproduct;
	}
	
	
	
}
