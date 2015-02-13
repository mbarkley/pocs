package org.jboss.errai.demo.server;

import java.io.File;
import java.util.Collections;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.SystemOutHandler;
import org.jboss.errai.demo.client.shared.AppBuilderEndpoint;
import org.jboss.errai.demo.client.shared.AppError;
import org.jboss.errai.demo.client.shared.AppReady;

@Stateless
public class AppBuilderEndpointImpl implements AppBuilderEndpoint {

  @Inject
  private Event<AppReady> appReadyEvent;
  
  @Inject
  private Event<AppError> appErrorEvent;
  
  @Context
  private HttpServletRequest req;
  
  @Resource
  private ManagedExecutorService executorService;

  @Override
  public Response compileApp(final String appId) {
    final String rootDir = req.getServletContext().getRealPath(File.separator);
    final File appPom = new File(rootDir + File.separator + appId + File.separator + "pom.xml");
    final String scriptPath = appId + "/target/" + appId + "/" +appId + "/" + appId + ".nocache.js";
      
    final InvocationRequest request = new DefaultInvocationRequest();
    request.setPomFile(appPom);
    request.setGoals(Collections.singletonList("install"));
    request.setOutputHandler(new SystemOutHandler());

    executorService.submit(new Runnable() {
      @Override
      public void run() {
        try {
          final InvocationResult result = new DefaultInvoker().execute(request);
          if (result.getExitCode() == 0) {
            appReadyEvent.fire(new AppReady(appId, scriptPath));
          }
          else {
            appErrorEvent.fire(new AppError("Failed with error: " + result.getExecutionException().getMessage()));
          }
        } 
        catch (Exception e) {
          appErrorEvent.fire(new AppError(e.getMessage()));
        }
      }
    });
            
    return Response.ok().build();
  }

}