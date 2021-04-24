package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

/**
 * @return
 */
public Connection connect() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project", "root", "");
			
			//checking whether the database is connected 
			if(connection != null) {
				System.out.println("Successfully Connected");
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
}
