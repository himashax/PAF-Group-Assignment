package com.resources;

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

import com.models.Researcher;
import com.dao.ResearcherDAOImpl;
import com.google.gson.Gson;

@Path("/researchers")
public class ResearcherResource {

	private ResearcherDAOImpl resDAOObject = new ResearcherDAOImpl();
	private Gson gsonObject;
	
	//API for Create researcher
	@POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addResearcher(String researcher) {
		
		gsonObject = new Gson();
		Researcher resObject = gsonObject.fromJson(researcher, Researcher.class);
		
		if(resObject.getResearcherID().isEmpty()||resObject.getFirstName().isEmpty()||resObject.getLastName().isEmpty()||resObject.getEmail().isEmpty()||resObject.getDepartment().isEmpty()) {
			return "Fields cannot empty";
		}else {
			return resDAOObject.createReseracher(resObject) + "\n" + researcher;
		}
    }
	
	//API for get all the researchers
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearchers() { 
		
		List<Researcher> list = resDAOObject.listResearchers();
		gsonObject = new Gson();
		
		//returns string value
		return gsonObject.toJson(list);
	}
	
	//API for get researcher by ID
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearcher(@PathParam("id") int id) { 
		Researcher res = resDAOObject.getResearcherByID(id);
		gsonObject = new Gson();
		return gsonObject.toJson(res);
	}
	
	//API for edit researcher details
	@PUT
	@Path("/edit") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateResearcher(String researcher) 
	{ 
		gsonObject = new Gson();
		Researcher resObject = gsonObject.fromJson(researcher, Researcher.class);
		
		if(resObject.getResearcherID().isEmpty()||resObject.getFirstName().isEmpty()||resObject.getLastName().isEmpty()||resObject.getEmail().isEmpty()||resObject.getDepartment().isEmpty()) {
			return "Fields cannot empty";
		}else {
			return resDAOObject.updateResearcher(resObject) + "\n" + researcher; 
		}
	}
	
	//API for delete researcher
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteResearcher(@PathParam("id") int id) {
		return resDAOObject.deleteResearcher(id);
	}
	  
}
