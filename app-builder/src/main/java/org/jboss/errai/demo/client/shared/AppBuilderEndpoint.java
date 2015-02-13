package org.jboss.errai.demo.client.shared;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/apps")
public interface AppBuilderEndpoint {

  @GET
  @Path("/{appId}")
  public Response compileApp(@PathParam("appId") String appId);

}
