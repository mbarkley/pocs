package org.jboss.errai.demo.server;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.jboss.errai.demo.client.shared.AppBuilderEndpoint;
import org.jboss.errai.demo.client.shared.AppReady;

@Stateless
public class AppBuilderEndpointImpl implements AppBuilderEndpoint {

  @Inject
  private Event<AppReady> appReady;

  @Override
  public Response loadApp(String appId) {
    // TODO
    return null;
  }

}