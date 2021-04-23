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

	private ProductDaoImpl pro = new ProductDaoImpl();
	List<Product> products;

	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String createProduct(Product p1) {
		if(p1.getName().isEmpty() || p1.getDate() == null || p1.getPrice()==0) {
			return "Fill in the empty fields";
		}
		if(pro.getProductById(p1.getProductId()).getId() == 0) {
			pro.createProduct(p1);
			return "Inserted product " + p1.getProductId() + " successfully";
		}else {
			return "Already existing product id";
		}		
	}
	
	@GET
	@Path("/productList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		return pro.listProducts();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProById(@PathParam("id") int id) {
		return pro.getProductById(id);
	}

	@PUT
	@Path("/update") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProduct(Product product) 
	{ 
		if (product.getName() == null || product.getName().isEmpty() || product.getId() == 0) {
			return "Enter Product Name";
		}else {
			 pro.updateProduct(product); 
			 return "Updated "+ product.getProductId() +" product successfully";
		}
	
	}
	
	@DELETE
	@Path("/delproduct/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@PathParam("id") int id) {
		pro.deleteProduct(id);
		return "Deleted successfully";
	}
}
