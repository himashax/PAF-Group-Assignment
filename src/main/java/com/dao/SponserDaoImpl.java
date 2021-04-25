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
	
	//DBConnection class object
	private DBConnection db = new DBConnection();

	
	//create a new sponsor by passing the column values
	public String insertSponserData(int sponserID, int productId, String firstName, String lastName, float sAmount, String compName) {
		
		  String result ="";
		  
		try {
		  //set up a database connection
		    Connection connection = db.connect();
		  
		 // query for inserting a new sponsor
		    String insertQuery = "insert into sponser values (?,?,?,?,?,?,?)";
		
			PreparedStatement ps = connection.prepareStatement(insertQuery);
		// binding values
			ps.setInt(1, 0);
			ps.setInt(2, sponserID);
			ps.setInt(3, productId);
			ps.setString(4, firstName);
			ps.setString(5, lastName);
			ps.setFloat(6, sAmount);
			ps.setString(7, compName);
		// execute the statement
			ps.execute();
			
			result = "Inserted Successfully!!";
		//close database connection
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//return the result of success or unsuccess message
		return result;
		
		
	}
	
	//view all the sponsors
	public ArrayList<Sponser> sponserList(){
		ArrayList<Sponser> s1 =new ArrayList<Sponser>();
		
		//activate DBConnection
		Connection con = db.connect();
		
		//query to retrieve all the sponser details
		String list = "select*from sponser";
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(list);
			
		//Iterate through the rows in the result set
			while(rs.next()) {
				Sponser s = new Sponser();
				
				s.setId(rs.getInt(1));
				s.setSponserID(rs.getInt(2));
				s.setProductId(rs.getInt(3));
				s.setfName(rs.getString(4));
				s.setlName(rs.getString(5));
				s.setAmount(rs.getFloat(6));
				s.setCompanyName(rs.getString(7));
				
				//Add sponsors to the list
				s1.add(s);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//return all the sponsers
		return s1;
		
	}
	
	//Update sponser details
	//update sponsor details by passing the column values
	public String updateSponserData(int id, int sponserID, int productId,String firstName, String lastName,float sAmount,String compName) {
		String result="";
		try {
		
	//activate DBConnection
		Connection connection = db.connect();
	
	//sql query to update sponser
		String updateQuery = "update sponser set sponserID = '"+sponserID+"',productId = '"+productId+"',firstName = '"+firstName+"', lastName = '"+lastName+"', sAmount = '"+sAmount+"', compName ='"+compName+"' where id = '"+id+"' ";
	
	// create a prepared statement
		PreparedStatement ps;
		ps = connection.prepareStatement(updateQuery);
	
	//execute the statement	
		ps.execute();
		
		result="Updated Successfully!!"; 
	
	//close the connection
		connection.close();

		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	//return the result of success or unsuccess message	
		return result;
		}
	
	
	//Delete Sponser according to the given id
	public String deleteSponserData(int id) {
		String result ="";
		try {
			
	//connect to the database		
		Connection connection = db.connect();
		
	//sql query to delete sponser for particular id
		String delQuery = "delete from sponser where id = '"+id+"'";
		
	// create a prepared statement
		PreparedStatement ps = connection.prepareStatement(delQuery);
		
	//execute the statement
		ps.execute();
		
		result = "Deleted Successfully!!";
		
	//close the connection
		connection.close();
		} catch (SQLException e) {

		e.printStackTrace();
		}
		
	//return the result of success or unsuccess message	
		return result;
		}
	
	
	//getting sponser details by id
    public Sponser getSponserById(int id) {
    	Sponser s = new Sponser();
    	
    //connect to database	
    	Connection connection = db.connect();
    	
    //sql query to choose a sponser with particualr id	
    	String objById = "select *from sponser where id = '"+id+"'";
    	try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(objById);
			while(rs.next()) {
				s.setId(rs.getInt(1));
				s.setSponserID(rs.getInt(2));
				s.setProductId(rs.getInt(3));
				s.setfName(rs.getString(4));
				s.setlName(rs.getString(5));
				s.setAmount(rs.getFloat(6));
				s.setCompanyName(rs.getString(7));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	//return values
    	return s;
    	
}
}
