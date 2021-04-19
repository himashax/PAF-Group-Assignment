package com.resources;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.models.Researcher;
import com.dao.ResearcherDAOImpl;
import com.google.gson.Gson;

@Path("/researchers")
public class ResearcherResource {

	private ResearcherDAOImpl resObject = new ResearcherDAOImpl();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearchers() { 
		
		ArrayList<Researcher> list = resObject.listResearchers();
		Gson test = new Gson();
		
		//returns string value
		return test.toJson(list);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCities(@PathParam("id") int id) { 
		Researcher res = resObject.getResearcherByID(id);
		Gson test = new Gson();
		return test.toJson(res);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteResearcher(@PathParam("id") int id) {
		return resObject.deleteResearcher(id);
	}
}
