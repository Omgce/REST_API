package com.op.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.op.model.Employee;
import com.op.model.Works_with;
import com.op.services.EmployeeService;
import com.op.services.Works_withService;

@Path("employee")
public class EmployeeResource {

	EmployeeService service = new EmployeeService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		List<Employee> list = service.getEmployees();
		return list;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setEmployees(Employee employee, @Context UriInfo uri) {
		service.addEmployee(employee);

		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(employee.getEmp_id())).build();
		return Response.created(location).entity(employee).build();
	}

	@PUT
	@Path("/{emp_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putEmployee(@PathParam("emp_id") int emp_id, Employee updateEmp) {
		updateEmp.setEmp_id(emp_id);
		service.updateEmployee(updateEmp);

	}

	@DELETE
	@Path("/{emp_id}")
	public void deleteEmployee(@PathParam("emp_id") int emp_id) {
		service.deleteEmployee(emp_id);
	}
}
