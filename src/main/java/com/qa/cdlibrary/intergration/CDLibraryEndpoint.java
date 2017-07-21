package com.qa.cdlibrary.intergration;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

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
	public String deleteCD(@PathParam("id") Long id) {return service.deleteCD(id); }

	@Path("/json/")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAllCD() {return service.deleteAllCD();}

    @Path("/json/{id}")
    @GET
    @Produces({ "application/json" })
    public  String findCDByID(@PathParam("id") Long id) {return service.findCDByID(id);
    }

	@GET
	@Path("/json/help")
		public Response getUserHistory() {
			String help = "The functions available and how to use them are as follows:\n" +
					"GET /json => all CDs shown\nGET /json/{id} => Get CD by it's id\n" +
					"POST /json => adds a CD in the json format like as follows: " +
					"{\"artistName\":\"Artist name goes here\",\"genre\":\"Genre goes" +
					" here\",\"albumTitle\":\"Album Title goes here\"}\n" +
					"DELETE /json => Deletes all CDs in the database\n DELETE /json/{id}" +
					" => Deletes a CD in the database by id number entered\n" +
					"PUT /json/{id} => Updates a CD entry by id, the unchanged values need " +
					"to be entered, entered must be in the format: " +
					"{\"id\":the id to update goes here,\"artistName\":\"The Updated artist name" +
					" goes here\",\"genre\":\"The updated genre\",\"albumTitle\":\"The updated genre\"}";
			return Response.status(200)
					.entity(help)
					.build();

		}

}
