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
	@Path("/json/{year}/{month}/{day}")
		public Response getUserHistory(
				@PathParam("year") int year,
				@PathParam("month") int month,
				@PathParam("day") int day) {

			String date = year + "/" + month + "/" + day;

			return Response.status(200)
					.entity("getUserHistory is called, year/month/day : " + date)
					.build();

		}

}
