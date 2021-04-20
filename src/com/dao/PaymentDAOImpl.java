package com.dao;

import java.sql.*;

import com.dbConnection.DBConnection;
import com.model.Payment;

public class PaymentDAOImpl {

	DBConnection db = new DBConnection();

	public String createPayment(Payment paymentObj) {

	Connection con = db.getConnection();

	String result = "";

	String insertPayment = "insert into payment values (?,?,?,?,?,?)";
	try {
	PreparedStatement ps = con.prepareStatement(insertPayment);
	ps.setInt(1, paymentObj.getId());
	ps.setInt(2, paymentObj.getPaymentID());
	ps.setDouble(3, paymentObj.getAmount());
	ps.setString(4, paymentObj.getType());
	ps.setInt(5, paymentObj.getProductID());
	ps.setInt(6, paymentObj.getCustomerID());

	ps.execute();

	result = "Inserted Successfully";

	con.close();

	} catch (SQLException |IndexOutOfBoundsException e) {
	e.printStackTrace();
	}
	return result;
	}


}
