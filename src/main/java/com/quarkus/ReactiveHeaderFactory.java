package com.quarkus;

import org.jboss.resteasy.reactive.common.util.MultivaluedTreeMap;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedMap;

import io.quarkus.rest.client.reactive.ReactiveClientHeadersFactory;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveHeaderFactory extends ReactiveClientHeadersFactory {

  @Override
  public Uni<MultivaluedMap<String, String>> getHeaders(MultivaluedMap<String, String> incomingHeaders) {
    MultivaluedMap<String, String> map = new MultivaluedTreeMap<>();
    map.putSingle("Token", "MyHeader");
    return Uni.createFrom().item(map);
  }
}