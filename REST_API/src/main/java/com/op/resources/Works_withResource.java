package com.op.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.model.Works_with;
import com.op.services.Works_withService;

@Path("works")
public class Works_withResource {

	Works_withService service = new Works_withService();

	@GET
	@Path("/{emp_id}/{client_id}/works_with")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Works_with> getWorkswithByEmployeeAndClient(@PathParam("emp_id") int emp_id,
			@PathParam("client_id") int client_id) {
		List<Works_with> workswithList = service.getWorks_withByEmployeeAndClientAndTotalsales(emp_id, client_id);
		return workswithList;
	}
}
