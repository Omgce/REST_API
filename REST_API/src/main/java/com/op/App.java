package com.op;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("app")
public class App {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public String demo() {
		return "Welcome";
	}
}
