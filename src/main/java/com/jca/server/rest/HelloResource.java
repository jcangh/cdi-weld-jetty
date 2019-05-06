package com.jca.server.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jca.server.service.HelloService;

@Path("/greetings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
	
	@Inject
	private HelloService service;
	
	@GET
	@Path("/{name}")
	public String sayHello(@PathParam("name") String name) {
		String nombre = service.sayHello(name);
		return nombre;
	}

}
