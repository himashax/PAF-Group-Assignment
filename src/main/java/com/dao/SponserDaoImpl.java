package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbConnection.DBConnection;
import com.models.Sponser;




public class SponserDaoImpl {
	private DBConnection db = new DBConnection();

	public String insertSponserData(String firstName, String lastName, float sAmount, String compName) {
		
		  String result ="";
		try {
		    Connection connection = db.connect();
		  
		 // create a prepared statement
		    String insertQuery = "insert into sponser values (?,?,?,?,?)";
		
			PreparedStatement ps = connection.prepareStatement(insertQuery);
		// binding values
			ps.setInt(1, 0);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setFloat(4, sAmount);
			ps.setString(5, compName);
		// execute the statement
			ps.execute();
			
			result = "Inserted Successfully!!";
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public ArrayList<Sponser> sponserList(){
		ArrayList<Sponser> s1 =new ArrayList<Sponser>();
		Connection con = db.connect();
		String list = "select*from sponser";
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(list);
		//iterate through the rows in the result set
			while(rs.next()) {
				Sponser s = new Sponser();
				
				s.setId(rs.getInt(1));
				s.setfName(rs.getString(2));
				s.setlName(rs.getString(3));
				s.setAmount(rs.getFloat(4));
				s.setCompanyName(rs.getString(5));
				s1.add(s);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s1;
		
	}
	
	public String updateSponserData(int id, String firstName, String lastName,float sAmount,String compName) {
		String result="";
		try {
		Connection connection = db.connect();
	// create a prepared statement
		String updateQuery = "update sponser set firstName = '"+firstName+"', lastName = '"+lastName+"', sAmount = '"+sAmount+"', compName ='"+compName+"' where id = '"+id+"' ";

		PreparedStatement ps;
		ps = connection.prepareStatement(updateQuery);
	//execute the statement	
		ps.execute();
		
		result="Updated Successfully!!"; 
		
		connection.close();

		} catch (SQLException e) {
		e.printStackTrace();
		}
		return result;
		}
	
	public String deleteSponserData(int id) {
		String result ="";
		try {
		Connection connection = db.connect();
	// create a prepared statement
		String delQuery = "delete from sponser where id = '"+id+"'";

		PreparedStatement ps = connection.prepareStatement(delQuery);
	//execute the statement
		ps.execute();
		
		result = "Deleted Successfully!!";
		
		connection.close();
		} catch (SQLException e) {

		e.printStackTrace();
		}
		return result;
		}
	
    public Sponser getSponserById(int id) {
    	Sponser s = new Sponser();
    	Connection connection = db.connect();
    	String objById = "select *from sponser where id = '"+id+"'";
    	try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(objById);
			while(rs.next()) {
				s.setId(rs.getInt(1));
				s.setfName(rs.getString(2));
				s.setlName(rs.getString(3));
				s.setAmount(rs.getFloat(4));
				s.setCompanyName(rs.getString(5));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return s;
    	
}
}
