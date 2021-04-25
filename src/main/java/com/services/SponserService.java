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
@Produces(MediaType.TEXT_PLAIN)
	public String addSponser(Sponser sp) {
	
	//check whether the fields are empty
	if(sp.getfName().isEmpty()||sp.getlName().isEmpty()||sp.getCompanyName().isEmpty()) {
		return "Please fill the necessary fields";
	//check the amount is greater than or equal to 0(positive value)	
	}else if(sp.getAmount()<=0) {
		return "Please enter positive amount";
	//check whether the id fields are empty	
	}else if(sp.getProductId()==0||sp.getSponserID()==0) {
		return "Please enter an integer value for id";
	//check whether the sponserID is a unique value	
	}else if(sponserDao.getSponserById(sp.getSponserID()).getId()!=0) {
		return "SponserID should be an unique value";
	}
	else {
		return sponserDao.insertSponserData(sp.getSponserID(),sp.getProductId(),sp.getfName(), sp.getlName(), sp.getAmount(), sp.getCompanyName());
	}
	
}


//update sponser details according to the id
@PUT
@Path("/updateSponser")
@Consumes(MediaType.APPLICATION_JSON)
	public String updateSponser(Sponser sp) {
	return sponserDao.updateSponserData(sp.getId(),sp.getSponserID(),sp.getProductId(),sp.getfName(),sp.getlName(),sp.getAmount(),sp.getCompanyName());
	
}


//delete sponser for the given id
@DELETE
@Path("/deleteSponser/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public String deleteSponser(@PathParam("id") int id) {
	return sponserDao.deleteSponserData(id);
	
}
}
