package org.jboss.errai.demo.client.shared;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/appbuilder")
public interface AppBuilderEndpoint {

  @GET
  @Consumes("application/json")
  public Response loadApp(String appId);

}
