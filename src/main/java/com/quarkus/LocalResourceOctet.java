package com.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/octet")
public class LocalResourceOctet {

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public String get(@HeaderParam("Accept") String accept,
                    @HeaderParam("Token") String token) {
    System.out.println("accept: " + accept);
    System.out.println("token: " + token);
    return "foo";
  }
}