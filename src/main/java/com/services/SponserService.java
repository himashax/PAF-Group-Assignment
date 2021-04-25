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

import com.dao.SponserDaoImpl;
import com.models.Sponser;

@Path("/sponsers")
public class SponserService {

SponserDaoImpl sponserDao = new SponserDaoImpl();

//get sponser details of the particular id
@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public Sponser getSponshershipById(@PathParam("id") int id) {
	return sponserDao.getSponserById(id);
}


//get all the sponsers
@GET
@Path("/getSponsers")
@Produces(MediaType.APPLICATION_JSON)
	public List<Sponser> getAllSponsers() {
	return sponserDao.sponserList();
}


//add Sponsers
@POST
@Path("/addSponsers")
@Consumes(MediaType.APPLICATION_JSON)
	public String addSponser(Sponser sp) {
	return sponserDao.insertSponserData(sp.getSponserID(),sp.getProductId(),sp.getfName(), sp.getlName(), sp.getAmount(), sp.getCompanyName());
	
}


//update sponser details according to the id
@PUT
@Path("/updateSponser")
@Consumes(MediaType.APPLICATION_JSON)
	public String updateSponser(Sponser sp) {
	String s = sponserDao.updateSponserData(sp.getId(),sp.getSponserID(),sp.getProductId(),sp.getfName(),sp.getlName(),sp.getAmount(),sp.getCompanyName());
	return s;
}


//delete sponser for the given id
@DELETE
@Path("/deleteSponser/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public String deleteSponser(@PathParam("id") int id) {
	return sponserDao.deleteSponserData(id);
	
}
}
