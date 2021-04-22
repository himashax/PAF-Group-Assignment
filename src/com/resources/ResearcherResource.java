package com.resources;

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

import com.models.Researcher;
import com.dao.ResearcherDAOImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/researchers")
public class ResearcherResource {

	private ResearcherDAOImpl resDAOObject = new ResearcherDAOImpl();
	
	@POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addResearcher(String researcher) {
		Gson test = new Gson();
		Researcher resObject = test.fromJson(researcher, Researcher.class);
		return resDAOObject.createReseracher(resObject) + "\n" + researcher;
    }
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearchers() { 
		
		ArrayList<Researcher> list = resDAOObject.listResearchers();
		Gson test = new Gson();
		
		//returns string value
		return test.toJson(list);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCities(@PathParam("id") int id) { 
		Researcher res = resDAOObject.getResearcherByID(id);
		Gson test = new Gson();
		return test.toJson(res);
	}
	
	@PUT
	@Path("/edit") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateResearcher(String researcher) 
	{ 
		Gson test = new Gson();
		Researcher resObject = test.fromJson(researcher, Researcher.class);
		return resDAOObject.updateResearcher(resObject) + "\n" + researcher; 
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteResearcher(@PathParam("id") int id) {
		return resDAOObject.deleteResearcher(id);
	}
}
