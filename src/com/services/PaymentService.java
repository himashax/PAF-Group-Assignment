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

	public static void main(String[] args) {
		
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createPayment(Payment payment) {
	
	return payDao.createPayment(payment);
	}


	@GET
	@Path("/getPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getAllPayment(){
		return payDao.listPayments();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Payment getPayById(@PathParam("id") int id) {
		return payDao.getPaymentById(id);
	}
	@PUT
	@Path("/updatepayment") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(Payment payment) 
	{ 
		return payDao.updatePayment(payment); 
	}
	@DELETE
	@Path("/delPayment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public String delPayment(@PathParam("id") int id) {
		return payDao.delPayment(id);
		
	}
}
