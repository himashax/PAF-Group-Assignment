package com.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/test")

public class Hello {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHello() {
	return "Hello World";
	}
}
