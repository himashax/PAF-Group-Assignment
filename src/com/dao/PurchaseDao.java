package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.models.Product_Purchase;

public class PurchaseDao {
	
	DBConnection dbconnect = new DBConnection();


public String insertProductPurchaseItems(Date date , Double total) {
		
		
		Connection con = dbconnect.connect();
		String result = "";
		
		String insertquery = "insert into product_purchase values (? , ? , ? )";
		try {
			PreparedStatement statement = con.prepareStatement(insertquery);
			
			statement.setInt(1, 0 );
			statement.setDate(2, date);
			statement.setDouble(3 , total);
			statement.execute();
			result = "inserted successfully";
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	return result;
	}

		public ArrayList<Product_Purchase> items () {
			ArrayList<Product_Purchase> p1 = new ArrayList<Product_Purchase> ();
			Connection con = dbconnect.connect();
			
			String retrieve = "select* from product_purchase ";
			
			try {
				Statement s = con.createStatement();
				
				ResultSet res = s.executeQuery(retrieve) ;
				
				while(res.next()) {
					
					Product_Purchase loc = new Product_Purchase();
					loc.setID(res.getInt(1));
					loc.setDate(res.getDate(2));
					loc.setTotal(res.getDouble(3));
					
					p1.add(loc);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p1;
			
		}
		
public String updateProductPurchaseItems(int id , Date date , Double total) {
	String result = "";
			Connection con = dbconnect.connect();
			
			String update = " update product_purchase set date =  '"+date+"', total = '"+total+"' where ID = '"+id+"' " ;
			try {
				PreparedStatement stat = con.prepareStatement(update);
				
				stat.execute();
				result = "updated successfully";
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;	
		}

public String deleteProductPurchaseItems(int id) {
	String result = "";
			try {
			Connection connection = dbconnect.connect();
			String delQuery = "delete from product_purchase where ID = '"+id+"'";
			PreparedStatement ps = connection.prepareStatement(delQuery);
			ps.execute();
			result = "deleted Successfully";
			connection.close();
			}catch(SQLException e) {
			e.printStackTrace();
			}
			return result;
}
public Product_Purchase getPurchaseProductByID(int id) {
	
	Product_Purchase item = new Product_Purchase();
	Connection connection = dbconnect.connect();
	String objectByID = "select * from product_purchase where ID = '"+id+"' ";
	try {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(objectByID);
		while(rs.next()) {
			item.setID(rs.getInt(1));
			item.setDate(rs.getDate(2));
			item.setTotal(rs.getDouble(3));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return item;
	
}

}
