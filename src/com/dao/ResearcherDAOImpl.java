package com.dao;

import com.models.Researcher;
import com.dbConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResearcherDAOImpl implements IResearcherDAO {

	//DBconnection class object to invoke the connectivity
	private DBConnection dbConnection = new DBConnection();
	
	
	//Create a new object/adding a new researcher to the system
	@Override
	public String createReseracher(Researcher res) {
		
		//Connect to the database
		Connection connection = dbConnection.getConnection();
		String output = "";
		
		//SQL query for inserting a new researcher
		String insertQuery = "insert into researcher values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(insertQuery);
			preStatement.setInt(1, 0);
			preStatement.setString(2, res.getResearcherID());
			preStatement.setString(3, res.getFirstName());
			preStatement.setString(4, res.getLastName());
			preStatement.setString(5, res.getEmail());
			preStatement.setString(6, res.getDepartment());
			
			//Add researcher
			preStatement.execute();
			
			output = "Inserted Sucessfully";
			
			//Disconnect from the database
			connection.close();
			
		} catch(SQLException|NullPointerException|IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		//Returns success/unsuccess message
		return output;
	}
	
	
	//Get all the researchers
	@Override
	public List<Researcher> listResearchers(){
		
		//Connect to the database
		Connection connection = dbConnection.getConnection();
		
		//SQL query to get all the researchers from the table
		String retrieveQuery = "select * from researcher";
		
		//Create a list object to store all the retrieved researcher objects
		List<Researcher> researcherList = new ArrayList<>();
		
		try {
			//Execute static retrieveQuery without parameters
			Statement statement = connection.createStatement();
			
			//Create ResultSet object to get database result set and execute SQL query
			ResultSet rs = statement.executeQuery(retrieveQuery);
			
			//Go through all the rows in the result set
			while(rs.next()) {
				//Researcher object to store researcher data through setters
				Researcher researcher = new Researcher();
				
				researcher.setId(rs.getInt(1));
				researcher.setResearcherID(rs.getString(2));
				researcher.setFirstName(rs.getString(3));
				researcher.setLastName(rs.getString(4));
				researcher.setEmail(rs.getString(5));
				researcher.setDepartment(rs.getString(6));
				
				//Add Researcher object to the list
				researcherList.add(researcher);
			}
			
			//Disconnect from the database
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Return all the researcher objects
		return researcherList;
	}
	
	
	//Retrieve researcher object along with details according to the given researcher id
	@Override
	public Researcher getResearcherByID(int id) {
		
		//Connect to the database
		Connection connection = dbConnection.getConnection();
		
		//SQL query to get a specific researcher
		String getResearcherQuery = "select * from researcher where id = '"+id+"' ";
		
		//Researcher object to store researcher data
		Researcher object = new Researcher();
		try {
			
			Statement st = connection.createStatement();
			
			//Create ResultSet object to get database result set and execute SQL query
			ResultSet rs = st.executeQuery(getResearcherQuery);
			
			//Go through all the rows in the result set
			while(rs.next()) {
				
				//Store researcher data through setters
				object.setId(rs.getInt(1));
				object.setResearcherID(rs.getString(2));
				object.setFirstName(rs.getString(3));
				object.setLastName(rs.getString(4));
				object.setEmail(rs.getString(5));
				object.setDepartment(rs.getString(6));
			}
			
			//Disconnect from the database
			connection.close();
			
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Return researcher object
		return object;
	}
	
	//Update researcher details
	@Override
	public String updateResearcher(Researcher res) {
		
		//Connect to the database
		Connection connection = dbConnection.getConnection();
		
		String output = "";
		
		//SQL query to update researcher details
		String updateQuery = "update researcher set researcherID = '"+res.getResearcherID()+"', first_name = '"+res.getFirstName()+"' , last_name =  '"+res.getLastName()+"', email = '"+res.getEmail()+"', department = '"+res.getDepartment()+"' where id = '"+res.getId()+"' ";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(updateQuery);
			
			//Update researcher
			preStatement.executeUpdate();
			
			output = "Updated Successfully";
			
			
			//Disconnect from the database
			connection.close();
			
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Returns success/unsuccess message
		return output;
	}
	
	
	//Delete researcher
	@Override
	public String deleteResearcher(int id) {
		
		//Connect to the database
		Connection connection = dbConnection.getConnection();
		
		//SQL query to delete researcher by the given id
		String deleteQuery = "delete from researcher where id = '"+id+"' ";
		String result = "";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(deleteQuery);
			
			//Delete researcher
			preStatement.execute();
			result = "Record Deleted Successfully";
			
			//Disconnect from the database
			connection.close();
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		}
		
		//Returns success/unsuccess message
		return result;
	}
	
	
	//Check if the researcher already exist
	public boolean checkAvailability(String id) {
		boolean researcherExist = false;
		
		Connection connection = dbConnection.getConnection();
		
		//Query for checking existence of data
		String availabilityQuery = "select researcherID from researcher where researcherID = '"+id+"' ";
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(availabilityQuery);
			
			if(rs.next()) {
				researcherExist = true;
			}else {
				researcherExist = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return researcherExist;
	}
	
}
