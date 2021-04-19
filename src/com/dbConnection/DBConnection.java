package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_test", "root", "");
			System.out.println("successfully connected");
			
		}catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
