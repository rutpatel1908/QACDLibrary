package com.qa.cdlibrary.intergration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdlibrary.business.CDLibraryService;
import com.qa.cdlibrary.business.CDLibraryService;

@Path("/cdlibrary")
public class CDLibraryEndpoint {

	@Inject
	private CDLibraryService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCD() {
		return service.getAllCD();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCD(String cd) {
		return service.createCD(cd);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCD(@PathParam("id") Long id, String cd) {
		return service.updateCD(id, cd);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCD(@PathParam("id") Long id) {
		return service.deleteCD(id);

	}

}
