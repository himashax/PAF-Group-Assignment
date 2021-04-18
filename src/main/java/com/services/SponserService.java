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

import com.dao.SponserDaoImpl;
import com.models.Sponser;

@Path("/sponsers")
public class SponserService {

SponserDaoImpl sponserDao = new SponserDaoImpl();
@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public Sponser getSponshershipById(@PathParam("id") int id) {
	return sponserDao.getSponserById(id);
}

@GET
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Sponser> getAllSponsers() {
	return sponserDao.sponserList();
}

@POST
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
	public String addSponser(Sponser sp) {
	String s = sponserDao.insertSponserData(sp.getfName(), sp.getlName(), sp.getAmount(), sp.getCompanyName());
	return s;
}

@DELETE
@Path("/deleteSponser/{id}")
@Produces(MediaType.APPLICATION_JSON)
	public String deleteSponser(@PathParam("id") int id) {
	String s = sponserDao.deleteSponserData(id);
	return s;
}
	
@PUT
@Path("/updateSponser")
@Consumes(MediaType.APPLICATION_JSON)
	public String updateSponser(Sponser sp) {
	String s = sponserDao.updateSponserData(sp.getId(),sp.getfName(),sp.getlName(),sp.getAmount(),sp.getCompanyName());
	return s;
}
}
