package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.ProductDaoImpl;
import com.google.gson.Gson;
import com.models.Product;

@Path("/Product")
public class ProductService {

	private ProductDaoImpl pro = new ProductDaoImpl();
	List<Product> products;

	@GET
	@Path("/productList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		return pro.listProducts();
	}

	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	public Product createProduct(Product p1) {
		return pro.createProduct(p1);
	}
	
	@GET
	@Path("/getProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProducts(@PathParam("id") int id) { 
		Product product = new Product();
		product = pro.getProductById(id);
		Gson test = new Gson();
		String jsonObject = test.toJson(product);
		return jsonObject;
	}

	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(Product product) 
	{ 
	 pro.updateProduct(product); 
	 return "Updated successfully";
	}
	
	@DELETE
	@Path("/delPro/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProduct(@PathParam("id") int id) {
		pro.deleteProduct(id);
	}
}
