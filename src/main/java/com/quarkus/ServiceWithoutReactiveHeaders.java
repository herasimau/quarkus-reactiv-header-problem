package com.quarkus;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;

@RegisterRestClient(baseUri = "http://localhost:9084")
//@RegisterClientHeaders(ReactiveHeaderFactory.class)
public interface ServiceWithoutReactiveHeaders {

    @GET
    @Path("/octet")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    Uni<File> getOctet();

}
