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
		
		@POST
		@Path("/customer")
		@Consumes(MediaType.APPLICATION_JSON)
		public Customer addCustomer(Customer c1) {
			
	
			return cr.createcustomer(c1);
		}
		
		@GET
		@Path("/customer/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Customer getCities(@PathParam("id") int id) {
			 return cr.getcustomerid(id);
		}
		
		@DELETE
		@Path("/deleteCustomer/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteProduct(@PathParam("id") int id) {
			return cr.deleteCustomer(id);
		}
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

