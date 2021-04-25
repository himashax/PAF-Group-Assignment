package com.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.PurchaseDao;
import com.models.Product_Purchase;

@Path("/products")
public class ProductPurchaseService {
	
PurchaseDao purchasedProduct = new PurchaseDao();


@GET	
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public Product_Purchase getPurchaseItemByID(@PathParam("id") int id) {
	return purchasedProduct.getPurchaseProductByID(id);
}


@GET	
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Product_Purchase> getPurchaseItems() {
	return purchasedProduct.items();
}
@POST
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
	public String addItem(Product_Purchase item) {
	String result = purchasedProduct.insertProductPurchaseItems(item.getDate(), item.getTotal());
	return result;
	}
	
@DELETE	
@Path("/deleteItem/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public String deletePurchaseItem(@PathParam("id") int id) {
	String result = purchasedProduct.deleteProductPurchaseItems(id);
	return result;
}
@PUT
@Path("/updateItem")
@Consumes(MediaType.APPLICATION_JSON)
public String updatePurchaseItem(Product_Purchase item) {
	String result = purchasedProduct.updateProductPurchaseItems(item.getID(), item.getDate(), item.getTotal());
	return result;
}
}
