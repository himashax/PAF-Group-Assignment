package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	//get db connection
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productpurchase", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully Connected");
			}
		} catch (SQLException | ClassNotFoundException e ) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
}
