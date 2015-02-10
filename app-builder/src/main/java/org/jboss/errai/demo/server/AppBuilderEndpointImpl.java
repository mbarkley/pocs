package org.jboss.errai.demo.server;

import java.io.File;
import java.util.Collections;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.apache.maven.shared.invoker.SystemOutHandler;
import org.jboss.errai.demo.client.shared.AppBuilderEndpoint;
import org.jboss.errai.demo.client.shared.AppReady;

@Stateless
public class AppBuilderEndpointImpl implements AppBuilderEndpoint {

  private Invoker invoker = new DefaultInvoker();
  
  @Inject
  private Event<AppReady> appReady;
  
  @Context
  private HttpServletRequest req;

  @Override
  public Response loadApp(String appId) {
    InvocationRequest request = new DefaultInvocationRequest();
    String rootDir = req.getServletContext().getRealPath(File.separator);
    File appPom = new File(rootDir + File.separator + appId + File.separator + "pom.xml");
    request.setPomFile(appPom);
    request.setGoals(Collections.singletonList("install"));
    request.setOutputHandler(new SystemOutHandler());
    
    try {
      InvocationResult result = invoker.execute(request);
      if (result.getExitCode() == 0) {
        System.out.println("Build Successful");
      }
      else {
        System.out.println("Build bombed");
      }
    } catch (MavenInvocationException e) {
      e.printStackTrace();
    }
    return Response.ok().build();
  }

}