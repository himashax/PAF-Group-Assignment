package com.dao;

import com.models.Researcher;
import com.dbConnection.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class ResearcherDAOImpl implements IResearcherDAO {

	private DBConnection dbConnection = new DBConnection();
	
	public Researcher create(Researcher res) {
		Connection connection = dbConnection.getConnection();
		
		String insertQuery = "insert into researcher values (?,?,?,?,?,?)";
		try {
			PreparedStatement preStatement = connection.prepareStatement(insertQuery);
			preStatement.setInt(1, 0);
			preStatement.setString(2, res.getFirstName());
			preStatement.setString(3, res.getLastName());
			preStatement.setString(4, res.getEmail());
			preStatement.setString(5, res.getDepartment());
			preStatement.setInt(6, res.getProduct());
			preStatement.execute();
			
			connection.close();
			
		} catch(SQLException|NullPointerException|IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public void createReseracher(String firstName , String lastName, String department) {
		
		Connection connection = dbConnection.getConnection();
		
		String insertQuery = "insert into researcher values (?,?,?,?)";
		try {
			PreparedStatement preStatement = connection.prepareStatement(insertQuery);
			preStatement.setInt(1, 0);
			preStatement.setString(2, firstName);
			preStatement.setString(3, lastName);
			preStatement.setString(4, department);
			preStatement.execute();
			
			connection.close();
			
		} catch(SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
				researcher.setResearcherID(rs.getInt(1));
				researcher.setFirstName(rs.getString(2));
				researcher.setLastName(rs.getString(3));
				researcher.setEmail(rs.getString(4));
				researcher.setDepartment(rs.getString(5));
				researcher.setProduct(rs.getInt(6));
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
				object.setResearcherID(rs.getInt(1));
				object.setFirstName(rs.getString(2));
				object.setLastName(rs.getString(3));
				object.setEmail(rs.getString(4));
				object.setDepartment(rs.getString(5));
				object.setProduct(rs.getInt(6));
			}
			connection.close();
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public void updateResearcher(int id, String firstName, String lastName, String department) {
		
		Connection connection = dbConnection.getConnection();
		
		String updateQuery = "update researcher set first_name = '"+firstName+"' , last_name =  '"+lastName+"', department = '"+department+"', "
				+ "where id = '"+id+"' ";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(updateQuery);
			preStatement.execute();
			connection.close();
			
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void deleteResearcher(int id) {
		
		Connection connection = dbConnection.getConnection();
		String deleteQuery = "delete from researcher where id = '"+id+"' ";
		PreparedStatement preStatement;
		try {
			preStatement = connection.prepareStatement(deleteQuery);
			preStatement.execute();
			connection.close();
		} catch (SQLException|NullPointerException e) {
			e.printStackTrace();
		}
	}

	
	
}
