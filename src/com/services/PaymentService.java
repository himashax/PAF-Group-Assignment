package com.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.dao.PaymentDAOImpl;
import com.google.gson.Gson;
import com.model.Payment;

@Path("/payments")

public class PaymentService {

	PaymentDAOImpl payDao = new PaymentDAOImpl();
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)

	public String createPayment(String payment) {
	Gson payGson = new Gson();
	Payment payObj = payGson.fromJson(payment, Payment.class);
	return payDao.createPayment(payObj) +"\n" + payment ;
	}


}
