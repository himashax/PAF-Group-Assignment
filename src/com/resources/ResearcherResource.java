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
	
	
	/**
	 * @param researcher
	 * @return
	 */
	@POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addResearcher(String researcher) {
		gsonObject = new Gson();
		Researcher resObject = gsonObject.fromJson(researcher, Researcher.class);
	
	
		return resDAOObject.createReseracher(resObject) + "\n" + researcher;
    }
	

	
	/**
	 * @return
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearchers() { 
		
		List<Researcher> list = resDAOObject.listResearchers();
		gsonObject = new Gson();
		
		//returns string value
		return gsonObject.toJson(list);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResearcher(@PathParam("id") int id) { 
		
		
			Researcher res = resDAOObject.getResearcherByID(id);
			gsonObject = new Gson();
			return gsonObject.toJson(res);
		
	}
	
	/**
	 * @param researcher
	 * @return
	 */
	@PUT
	@Path("/edit") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON) 
	public String updateResearcher(String researcher) 
	{ 
		gsonObject = new Gson();
		Researcher resObject = gsonObject.fromJson(researcher, Researcher.class);
		return resDAOObject.updateResearcher(resObject) + "\n" + researcher; 
	}
	
	/**
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteResearcher(@PathParam("id") int id) {
		
		
			return resDAOObject.deleteResearcher(id);
		
	}
}
