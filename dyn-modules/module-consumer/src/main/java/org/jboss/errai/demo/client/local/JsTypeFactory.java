package org.jboss.errai.demo.client.local;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.jboss.errai.demo.client.DepScopedService;
import org.jboss.errai.demo.client.Employee;

@ApplicationScoped
public class JsTypeFactory {

  public static native Employee create(final String firstName, final String lastName, final String email)  /*-{
    return $wnd.Core.Employee.create(firstName, lastName, email);
  }-*/;
  
  @Produces
  private DepScopedService produceDepScopedService() {
    return getDepScopedService("Hello World native!!!");
  }
  
  private native DepScopedService getDepScopedService(final String msg)  /*-{
    return new $wnd.DepScopedServiceImpl(msg);
  }-*/;
    
  
}
