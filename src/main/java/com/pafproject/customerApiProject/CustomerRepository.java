package com.pafproject.customerApiProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerRepository {
	public Connection getconnection() {
		   Connection con = null;
			String url ="Jdbc:mysql://localhost:3306/customerapiproject";
			String username = "root";
			String password = "";
			try {																		//DB Connection
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("success");
			return con;
		}	
	

	 List<Customer> customers;
	public CustomerRepository() {
		
		//declare arraylist
		customers = new ArrayList<>();
		
		
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("Nimal");
		c1.setAddress("hibutana");
		c1.setPhoneno(077543245);
		c1.setEmail("nimal@gmail.com");
		c1.setOccupation("bankmanager");
		c1.setNeedproduct("websystem");
		
		Customer c2 = new Customer();
		c2.setId(2);
		c2.setName("kamal");
		c2.setAddress("horana");
		c2.setPhoneno(074543245);
		c2.setEmail("kamal@gmail.com");
		c2.setOccupation("ceo");
		c2.setNeedproduct("cybersystem");
		
		Customer c3 = new Customer();
		c3.setId(3);
		c3.setName("bimal");
		c3.setAddress("kelaniya");
		c3.setPhoneno(077543452);
		c3.setEmail("bimal@gmail.com");
		c3.setOccupation("manager");
		c3.setNeedproduct("business");
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
	}
	//method to retrive all the customer
	public List<Customer> getAllCustomers(){
		return customers;
		
	}
	//create customer
	public Customer createcustomer(Customer c1) {
		String insertSql = "INSERT INTO `customer`(`id`, `name`, `address`, `phoneno`, `email`, `occupation`, `needproduct`) VALUES (?,?,?,?,?,?,?)";
		Connection con = getconnection();
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, 0);
			st.setString(2,c1.name);
			st.setString(3,c1.address);
			st.setInt(4, c1.phoneno);
			st.setString(5, c1.email);
			st.setString(6, c1.occupation);
			st.setString(7, c1.needproduct);
			
			String output = "Inserted successfully"; 
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		customers.add(c1);
		System.out.println(customers);
		return c1;
	}
	//retrive customer
	public  Customer getcustomerid(int id)
	{
		
		String getsql = "select * from customer where id = '"+id+"' ";
		Customer cd = new Customer();
		Connection con = getconnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet c1 = st.executeQuery(getsql);
			
			while(c1.next()) {
				
				cd.setId(c1.getInt(1));
				cd.setName(c1.getString(2));
				cd.setAddress(c1.getString(3));
				cd.setPhoneno(c1.getInt(4));
				cd.setEmail(c1.getString(5));
				cd.setOccupation(c1.getString(6));
				cd.setNeedproduct(c1.getString(3));
				
			}
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cd;
		
	}
	//delete customer from data base
	public String deleteCustomer(int id) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String deleteCustomer = "DELETE FROM customer WHERE id = '"+id+"'";
			PreparedStatement ps = con.prepareStatement(deleteCustomer);
			ps.execute();
			
			output = "Delete Successful";
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
		//update customer from data base
	public String updateCustomer(Customer customer) {
		String output = "";
		try {
			Connection con = getconnection();
			
			String updateCustomer = "UPDATE customer SET id='"+customer.getId()+"',name='"+customer.getName()+"',address='"+customer.getAddress()+"',phoneno='"+customer.getPhoneno()+"',email='"+customer.getEmail()+"',occupation='"+customer.getOccupation()+"',needproduct='"+customer.getNeedproduct()+"' WHERE id='"+customer.getId()+"'";
			PreparedStatement st = con.prepareStatement(updateCustomer);
			
			
			
			st.executeUpdate();
			output = "Update Sucessfull";
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return output;

	}
}

	
	
	

