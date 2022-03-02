package com.quarkus;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;

@Path("/header")
public class ExampleResource {

    @RestClient
    ServiceWithReactiveHeaders withReactiveHeaders;

    @RestClient
    ServiceWithoutReactiveHeaders withoutReactiveHeaders;

    @GET
    @Path("/with-reactive-headers")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TestResponse> withReactiveHeaders() {
        return withReactiveHeaders.getOctet()
            .onItem()
            .transformToUni(file -> {
                return Uni.createFrom().item(new TestResponse(file.getName()));
            });
    }

    @GET
    @Path("/without-reactive-headers")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<TestResponse> withoutReactiveHeaders() {
        return withoutReactiveHeaders.getOctet()
            .onItem()
            .transformToUni(file -> {
                return Uni.createFrom().item(new TestResponse(file.getName()));
            });
    }
}