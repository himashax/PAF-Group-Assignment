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
import com.models.Product;

@Path("/product")
public class ProductService {

	//declare a common ProductDaoImpl type object 
	private ProductDaoImpl pro = new ProductDaoImpl();
	List<Product> products;

	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String createProduct(Product p1) {
		//check the name field is empty or date is null or price is 0
		if(p1.getName().isEmpty() || p1.getDate() == null || p1.getPrice()==0) {
			return "Fill in the empty fields";
		}
		//check whether the new product Id is a duplicate Id 
		if(pro.getProductById(p1.getProductId()).getId() == 0) {
			//call the createProduct() method to create the new product 
			pro.createProduct(p1);
			//return a successful message
			return "Inserted product " + p1.getProductId() + " successfully";
		}else {
			//return message if the product id is already existing
			return "Already existing product id";
		}		
	}
	
	//get list of products 
	
	@GET
	@Path("/productList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		return pro.listProducts();
	}

	//get a particular product by passing the productId
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProById(@PathParam("id") int id) {
		return pro.getProductById(id);
	}

	
	//update the product 
	
	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(Product product) 
	{ 
		//check whether the name is empty or id is 0 when updating 
		if (product.getName() == null || product.getName().isEmpty() || product.getId() == 0) {
			
			//display a message to enter the product name if the name field is empty.
			return "Enter Product Name";
		}else {
			//update the product details
			 pro.updateProduct(product); 
			 
			 //display update success message
			 return "Updated "+ product.getProductId() +" product successfully";
		}
	
	}
	
	//delete a particular product by passing the id
	
	@DELETE
	@Path("/delproduct/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@PathParam("id") int id) {
		//call the deleteProduct() to delete the product
		pro.deleteProduct(id);
		//confirm message 
		return "Deleted successfully";
	}
}
