package com.pafproject.customerApiProject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customers")              ///anotation
public class CustomerResource {
	
	
		CustomerRepository cr = new CustomerRepository();

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Customer> getAllStudent() {
			
			return cr.getAllCustomers();
			
			
		}
		//path to add  customer
		
		@POST
		@Path("/customer")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String addCustomer(Customer c1) {
			
			if(c1.getName().isEmpty()) {
				return "name is null";
			}
			else {
			 cr.createcustomer(c1);
			 return "inserted successfully";
			}
		
		}
		//path to retrive customer
		@GET
		@Path("/customer/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Customer getCities(@PathParam("id") int id) {
			 return cr.getcustomerid(id);
		}
		//path to delete customer
		@DELETE
		@Path("/deleteCustomer/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteProduct(@PathParam("id") int id) {
			return cr.deleteCustomer(id);
		}
		//path to update customer
		@PUT
		@Path("/update") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updateCustomer(Customer customer) 
		{ 
		 return cr.updateCustomer(customer); 
		 
		}
		@GET
		@Path("/")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Customer> getallcustomer(){
			return cr.getAllCustomers();
		}
}

