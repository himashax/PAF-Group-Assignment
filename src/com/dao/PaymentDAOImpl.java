package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

	public List<Payment> listPayments(){

		List<Payment> paymentList = new  ArrayList<>();
		
		try{
			Connection connection = db.getConnection();
			String payList = "select * from payment";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(payList);

			while(rs.next()){
				Payment payment = new Payment();

				payment.setId(rs.getInt(1));
				payment.setPaymentID(rs.getInt(2));
				payment.setAmount(rs.getDouble(3));
				payment.setType(rs.getString(4));
				payment.setProductID(rs.getInt(5));
				payment.setCustomerID(rs.getInt(6));

				paymentList.add(payment);
			}			

		}catch(SQLException e){
			e.printStackTrace();
	 	} 
		
		
		return paymentList;
	}
	public Payment getPaymentById(int id) {
    	Payment p = new Payment();
    	Connection connection = db.getConnection();
    	String oId = "select * from payment where id = '"+id+"'";
    	try {
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(oId);
			while(rs.next()) {
				p.setId(rs.getInt(1));
				p.setPaymentID(rs.getInt(2));
				p.setAmount(rs.getDouble(3));
				p.setType(rs.getString(4));
				p.setProductID(rs.getInt(5));
				p.setCustomerID(rs.getInt(6));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return p;
    	
}
	public String updatePayment(Payment payment) {
		String output = "";
		try {
			Connection con = db.getConnection();
			
			String updatePayment = "UPDATE payment SET paymentID='"+payment.getPaymentID()+"',amount='"+payment.getAmount()+"',type='"+payment.getType()+"',productID='"+payment.getProductID()+"',`customerID`='"+payment.getCustomerID()+"' WHERE id ='"+payment.getId()+"'";
			
			PreparedStatement st = con.prepareStatement(updatePayment);
			
			st.executeUpdate();
			output = "Update Sucessfull";
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return output;

	}
	public String delPayment(int id) {
		String result ="";
		try {
		Connection connection = db.getConnection();
		String delQry = "delete from payment where id = '"+id+"'";

		PreparedStatement ps = connection.prepareStatement(delQry);
		ps.execute();
		
		result = "Successfully deleted";
		
		connection.close();
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return result;
		}


}
