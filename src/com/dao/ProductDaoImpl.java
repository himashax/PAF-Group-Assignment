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
	
	//instantiating a DBConnection type object
	DBConnection db = new DBConnection();
	
	List<Product> products;
	
	//method to insert a new product passing a Product type object as the parameter
	public Product createProduct(Product p1) {

		//establishing a connection
		Connection connection = db.connect();
		
		//query to insert a product to the product table in the database 
		String insertProduct = "INSERT INTO `product`(`product_id`, `product_name`, `date`, `price`,`resId`) VALUES (?,?,?,?,?)";

		//set values
		try {
			PreparedStatement ps = connection.prepareStatement(insertProduct);

			ps.setInt(1, p1.getProductId());
			ps.setString(2, p1.getName());
			ps.setDate(3, p1.getDate());
			ps.setDouble(4, p1.getPrice());
			ps.setString(5, p1.getResId());
			
			ps.execute();

			//close the connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return the product type object
		return p1;
	}
	
	//method to retrieve the list of all products
	public List<Product> listProducts() {
		List<Product> productList = new ArrayList<>();

		try {
			Connection connection = db.connect();
			
			//query to retrieve all the products from the database
			String prodList = "select * from product";

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(prodList);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProductId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getDate(4));
				product.setPrice(rs.getDouble(5));
				product.setResId(rs.getString(6));

				//add each an every object to the list
				productList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//return the list
		return productList;
	}
	
	//get a particular product by passing the product id
	public Product getProductById(int id) {
		
		//declare a product type object
		Product product = new Product();

		try {
			Connection connection = db.connect();
			
			//query to get a particular product by the id
			String productList = "select * from product where product_id = '" + id + "'";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(productList);

			while (rs.next()) {

				product.setId(rs.getInt(1));
				product.setProductId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getDate(4));
				product.setPrice(rs.getDouble(5));
				product.setResId(rs.getString(6));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}
	
	//update a product by passing a product type object as the parameter
	public void updateProduct(Product product) {

		try {
			Connection connection = db.connect();

			//query to update the product details by setting the values respectively
			String updateProduct = "update product set product_id = '" + product.getProductId() + "', product_name ='"
					+ product.getName() + "', date = '" + product.getDate() + "', price = '" + product.getPrice()+ "', resId = '"+ product.getResId()+"' where id = '" + product.getId() + "'";

			PreparedStatement ps = connection.prepareStatement(updateProduct);
			ps.executeUpdate();
			
			//close the connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//delete a product by passing the id
	public void deleteProduct(int id) {

		try {
			Connection connection = db.connect();

			//query to delete a product
			String deleteProduct = "delete from product where id = '" + id + "'";
			PreparedStatement ps = connection.prepareStatement(deleteProduct);
			ps.execute();

			//close the connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean checkCharacter(double price) {
		try {
			String.valueOf(price);
			return true;
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

}
