package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//A common method to connect to the DB
public class DBConnection {
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Adding necessary details to connect to the Database server
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project", "root", "");
			
			if(connection != null) {
				System.out.println("Successfully Connected");
			}
		} catch (SQLException |ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
}
