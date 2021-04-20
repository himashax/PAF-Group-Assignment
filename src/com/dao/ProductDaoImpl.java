package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.DBConnection;
import com.models.Product;

public class ProductDaoImpl {
DBConnection db = new DBConnection();
	
	List<Product> products;
	public ProductDaoImpl() {
		
		products = new ArrayList<>();

		Product prod3 = new Product();
		prod3.setProductId(789);
		prod3.setName("Fire");
		prod3.setDate("15-04-2020");
		prod3.setPrice(50000.00);

		products.add(prod3);

	}
	
	public Product createProduct(Product p1) {
		
		Connection connection = db.connect();
		String insertProduct = "INSERT INTO `product`(`product_id`, `product_name`, `date`, `price`) VALUES (?,?,?,?)"; 
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(insertProduct);
			
			ps.setInt(1, p1.getProductId());
			ps.setString(2, p1.getName());
			ps.setString(3, p1.getDate());
			ps.setDouble(4, p1.getPrice());

			
			ps.execute();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		products.add(p1);
		return p1;
	}
	
	public ArrayList<Product> listProducts(){
		ArrayList<Product> productList = new ArrayList<>();
		
		try {
			Connection connection = db.connect();
			String prodList = "select * from product";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(prodList);
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProductId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getString(4));
				product.setPrice(rs.getDouble(5));

				
				productList.add(product);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return productList;
	}
	
	public Product getProductById(int id){
		Product product = new Product();
		
		try {
			Connection connection = db.connect();
			String productList = "select * from product where id = '"+id+"'";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(productList);
			
			while(rs.next()) {
				
				product.setId(rs.getInt(1));
				product.setProductId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getString(4));
				product.setPrice(rs.getDouble(5));


			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return product;
	}
	

	public void updateProduct(Product product) {
		
		try {
			Connection connection = db.connect();
			
			String updateProduct = "update product set product_id = '"+product.getProductId()+"', product_name ='"+product.getName()+"', date = '"+product.getDate()+"',"
					+ " price = '"+product.getPrice()+"' where id = '"+product.getId()+"'";
			
			PreparedStatement ps = connection.prepareStatement(updateProduct);
			ps.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteProduct(int id) {

		try {
			Connection connection = db.connect();
			
			String deleteProduct = "delete from product where id = '"+id+"'";
			PreparedStatement ps = connection.prepareStatement(deleteProduct);
			ps.execute();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveResearchers(Product p1) {
		Connection connection = db.connect();
		String insertProduct = "INSERT INTO `productRes`(`product_id`, `resId`) VALUES (?,?)";
	
		try {
	//		for (String resId : p1.getRes()) {
				PreparedStatement ps = connection.prepareStatement(insertProduct);
	//
				ps.setInt(1, p1.getProductId());
	//			ps.setString(2, resId);
	//
	//			ps.execute();
	//		}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
