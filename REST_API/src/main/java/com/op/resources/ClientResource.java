package com.op.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.op.model.Client;
import com.op.services.ClientService;

@Path("client")
public class ClientResource {

	ClientService service = new ClientService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getClients() {
		List<Client> list = service.getClients();
		return list;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setClients(Client client, @Context UriInfo uri) {

		service.addClient(client);
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(client.getClient_id())).build();

		return Response.created(location).entity(client).build();
	}

	@PUT
	@Path("/{client_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putClients(@PathParam("client_id") int client_id, Client updateClient) {
		updateClient.setClient_id(client_id);
		service.updateClient(updateClient);
	}

	@DELETE
	@Path("/{client_id}")
	public void deleteClients(@PathParam("client_id") int client_id) {
		service.deleteClient(client_id);
	}
	
	
}
