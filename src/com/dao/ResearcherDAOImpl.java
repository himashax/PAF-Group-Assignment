package com.dao;

import com.models.Researcher;
import com.dbConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class ResearcherDAOImpl implements IResearcherDAO {

	private DBConnection dbConnection = new DBConnection();
	
	@Override
	public String createReseracher(Researcher res) {
		Connection connection = dbConnection.getConnection();
		String output = "";
		String insertQuery = "insert into researcher values (?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = connection.prepareStatement(insertQuery);
			preStatement.setInt(1, 0);
			preStatement.setString(2, res.getResearcherID());
			preStatement.setString(3, res.getFirstName());
			preStatement.setString(4, res.getLastName());
			preStatement.setString(5, res.getEmail());
			preStatement.setString(6, res.getDepartment());
			preStatement.execute();
			
			output = "Inserted Sucessfully";
			
			connection.close();
			
		} catch(SQLException|NullPointerException|IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	
	@Override
	public ArrayList<Researcher> listResearchers(){
		Connection connection = dbConnection.getConnection();
		String retrieveQuery = "select * from researcher";
		
		ArrayList<Researcher> researcherList = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(retrieveQuery);
			while(rs.next()) {
				Researcher researcher = new Researcher();
				researcher.setId(rs.getInt(1));
				researcher.setResearcherID(rs.getString(2));
				researcher.setFirstName(rs.getString(3));
				researcher.setLastName(rs.getString(4));
				researcher.setEmail(rs.getString(5));
				researcher.setDepartment(rs.getString(6));
				researcherList.add(researcher);
			}
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return researcherList;
	}
	
	
	@Override
	public Researcher getResearcherByID(int id) {
		
		Connection connection = dbConnection.getConnection();
		String deleteQuery = "select * from researcher where id = '"+id+"' ";
		
		Researcher object = new Researcher();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(deleteQuery);
			while(rs.next()) {
				object.setId(rs.getInt(1));
				object.setResearcherID(rs.getString(2));
				object.setFirstName(rs.getString(3));
				object.setLastName(rs.getString(4));
				object.setEmail(rs.getString(5));
				object.setDepartment(rs.getString(6));
			}
			connection.close();
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	
	@Override
	public String updateResearcher(Researcher res) {
		
		Connection connection = dbConnection.getConnection();
		
		String output = "";
		
		String updateQuery = "update researcher set researcherID = '"+res.getResearcherID()+"', first_name = '"+res.getFirstName()+"' , last_name =  '"+res.getLastName()+"', email = '"+res.getEmail()+"', department = '"+res.getDepartment()+"' where id = '"+res.getId()+"' ";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(updateQuery);
			
			preStatement.execute();
			output = "Updated Successfully";
			connection.close();
			
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	
	@Override
	public String deleteResearcher(int id) {
		
		Connection connection = dbConnection.getConnection();
		String deleteQuery = "delete from researcher where id = '"+id+"' ";
		String result = "";
		PreparedStatement preStatement;
		try {
			preStatement = connection.prepareStatement(deleteQuery);
			preStatement.execute();
			result = "Record Deleted Successfully";
			connection.close();
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
