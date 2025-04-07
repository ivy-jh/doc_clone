package com.axonivy.connectivity.rest.provider;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.axonivy.connectivity.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("zip")
@Tag(name = "CRM") // a name that can be used to cluster similar services
public class OpenApiResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(description = "finds customers in the CRM by ZIP code") // prose text
  @ApiResponse(responseCode = "200", description = "matching persons") // possible responses
  public List<Person> findPersonByZip(
    @Parameter(required = true, example = "CH-6300", description = "a ZIP with prefixed country code")
    @QueryParam("zip") String zip, // mandatory parameter with rich docs.
    @Parameter(example = "active, inactive, suspended")
    @QueryParam("status") String status
  ) {
    return UserRepo.findByZip(zip, status);
  }
}
