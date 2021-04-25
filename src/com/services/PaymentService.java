package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.PaymentDAOImpl;
import com.google.gson.Gson;
import com.model.Payment;

@Path("/payments")

public class PaymentService {

	PaymentDAOImpl payDao = new PaymentDAOImpl();
	
	//create payment API
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createPayment(Payment payment) {
	
		 if(payment.getPaymentID() == 0) {
			 return "Payment id cannot be empty" ;
		 }else if(payment.getAmount() == 0) {
			 return "amount cannot be empty";
		 }else if(payment.getType().isEmpty()) {
			 return "type cannot be empty" ;
		 }else if(payment.getProductID() == 0) {
			 return "product id cannot be empty";
		 }else if(payment.getCustomerID() == 0) {
			 return "customer id cannot be empty";
		 }else {
			 return payDao.createPayment(payment);
		 }
	
	}


	//retrieve all payments API
	@GET
	@Path("/getPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayment(){
		return payDao.listPayments();
	}
	
	//retrieve payment by id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Payment getPayById(@PathParam("id") int id) {
		return payDao.getPaymentById(id);
	}
	
	//update payment API
	@PUT
	@Path("/updatepayment") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(Payment payment) 
	{ 
		 if(payment.getId() == 0) {
			 return "id cannot be empty";
		 }else if(payment.getPaymentID() == 0) {
			 return "Payment id cannot be empty" ;
		 }else if(payment.getAmount() == 0) {
			 return "amount cannot be empty";
		 }else if(payment.getType().isEmpty()) {
			 return "type cannot be empty" ;
		 }else if(payment.getProductID() == 0) {
			 return "product id cannot be empty";
		 }else if(payment.getCustomerID() == 0) {
			 return "customer id cannot be empty";
		 }else {
		return payDao.updatePayment(payment); 
		 }
	}
	
	//delete payment API
	@DELETE
	@Path("/delPayment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public String delPayment(@PathParam("id") int id) {
		return payDao.delPayment(id);
		
	}
}
