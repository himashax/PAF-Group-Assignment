package com.services;

import java.sql.SQLException;
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

	// declare a common ProductDaoImpl type object
	private ProductDaoImpl pro = new ProductDaoImpl();
	List<Product> products;

	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createProduct(Product p1) {
		// check the name field is empty or date is null or price is 0
		if (p1.getName().isEmpty() || p1.getDate() == null || p1.getResId().isEmpty()) {
			return "Fill in the empty fields";
		} else if (p1.getPrice() <= 0) {
			// if the price is negative or zero
			return "Enter a positive value for price";
		}

		// check whether the new product Id is a duplicate Id
		try {
			if (pro.getProductById(p1.getProductId()).getId() == 0) {

				// call the createProduct() method to create the new product
				try {
					pro.createProduct(p1);
				} catch (SQLException e) {
					return "Error occured in " + e.getMessage();
				}

				// return a successful message
				return "Inserted product " + p1.getProductId() + " successfully";

			} else {
				// return message if the product id is already existing
				return "Already existing product id";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// get list of products

	/**
	 * @return
	 */
	@GET
	@Path("/productList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		try {
			return pro.listProducts();
		} catch (SQLException e) {
			e.printStackTrace();
			return products;
		}
	}

	// get a particular product by passing the productId

	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProById(@PathParam("id") int id) {
		try {
			return pro.getProductById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// update the product

	/**
	 * @param product
	 * @return
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProduct(Product product) {
		// check whether the name is empty or id is 0 when updating
		if (product.getName() == null || product.getName().isEmpty() || product.getId() == 0 || product.getResId().isEmpty()) {

			// display a message to enter the product name if the name field is empty.
			return "Fill the empty fields";
		} else if (product.getPrice() <= 0) {
			return "Enter a positive value for the price";
		} else {
			// update the product details
			try {
				pro.updateProduct(product);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// display update success message
			return "Updated " + product.getProductId() + " product successfully";
		}

	}

	// delete a particular product by passing the id

	/**
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delproduct/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@PathParam("id") int id) {
		// call the deleteProduct() to delete the product
		try {
			pro.deleteProduct(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// confirm message
		return "Deleted successfully";
	}

}
