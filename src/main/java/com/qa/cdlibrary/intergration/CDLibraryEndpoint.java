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
	public String getAllMovies() {
		return service.getAllMovies();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addMovie(String movie) {
		return service.createMovie(movie);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMovie(@PathParam("id") Long id, String movie) {
		return service.updateMovie(id, movie);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);

	}

}
