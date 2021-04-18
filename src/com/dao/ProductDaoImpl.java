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

		Product prod1 = new Product();
//		prod1.setId(1);
		prod1.setProduct_id(123);
		prod1.setName("Sir");
		prod1.setDate("15-04-2020");
		prod1.setPrice(2000.00);

		Product prod2 = new Product();
//		prod2.setId(2);
		prod2.setProduct_id(456);
		prod2.setName("Sand");
		prod2.setDate("18-04-2020");
		prod2.setPrice(36500.00);

		Product prod3 = new Product();
//		prod3.setId(3);
		prod3.setProduct_id(789);
		prod3.setName("Fire");
		prod3.setDate("15-04-2020");
		prod3.setPrice(50000.00);

		products.add(prod1);
		products.add(prod2);
		products.add(prod3);

	}
	
	public List<Product> getAllProducts(){
		
		return products;
	}
	
	public Product createProduct(Product p1) {
		
		Connection connection = db.connect();
		String insertProduct = "INSERT INTO `product`(`product_id`, `product_name`, `date`, `price`) VALUES (?,?,?,?)"; 
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(insertProduct);
			
			ps.setInt(1, p1.getProduct_id());
			ps.setString(2, p1.getName());
			ps.setString(3, p1.getDate());
			ps.setDouble(4, p1.getPrice());

			
			ps.execute();
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		products.add(p1);
		System.out.println(products);
		return p1;
	}
	
	public ArrayList<Product> listProducts(){
		ArrayList<Product> product_list = new ArrayList<>();
		
		try {
			Connection connection = db.connect();
			String prodList = "select * from product";
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(prodList);
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setProduct_id(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getString(4));
				product.setPrice(rs.getDouble(5));

				
				product_list.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product_list;
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
				product.setProduct_id(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setDate(rs.getString(4));
				product.setPrice(rs.getDouble(5));


			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}
	
	/*public void updateProduct(int id, int product_id, String name, String date, Double price) {
		Connection connection = db.connect();
		
		String updateProduct = "update product set product_id = '"+product_id+"' , product_name =  '"+name+"', date = '"+date+"' ,"
				+ " price = '"+price+"' where id = '"+id+"' ";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(updateProduct);
			preStatement.executeUpdate();
			connection.close();
			
		} catch (SQLException|NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}*/
	
	public void updateProduct(Product product) {
		
		try {
			Connection connection = db.connect();
			
			String updateProduct = "update product set product_id = '"+product.getProduct_id()+"', product_name ='"+product.getName()+"', date = '"+product.getDate()+"',"
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
	
	public static void main(String[] args) {
		Product pro = new Product();
		
		pro.setProduct_id(1702);
		pro.setName("study");
		pro.setDate("2021-01-20");
		pro.setPrice(90000);
		
		//createProduct(pro);
		System.out.println("Hari");
	}
}
