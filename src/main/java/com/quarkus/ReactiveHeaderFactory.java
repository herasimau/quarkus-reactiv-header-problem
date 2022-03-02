package com.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedMap;

import io.quarkus.rest.client.reactive.ReactiveClientHeadersFactory;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveHeaderFactory extends ReactiveClientHeadersFactory {

  @Override
  public Uni<MultivaluedMap<String, String>> getHeaders(MultivaluedMap<String, String> incomingHeaders) {
    return Uni.createFrom().item("MyHeader").map(token -> {
      incomingHeaders.putSingle("Token", token);
      return incomingHeaders;
    });

  }
}