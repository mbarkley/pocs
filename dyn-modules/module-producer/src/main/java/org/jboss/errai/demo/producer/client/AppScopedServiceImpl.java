package org.jboss.errai.demo.producer.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.errai.demo.core.client.AppScopedService;
import org.jboss.errai.demo.core.client.CrossModuleEvent;

import jsinterop.annotations.JsType;

@JsType
@ApplicationScoped
public class AppScopedServiceImpl implements AppScopedService {

  @Inject
  private HelloWorldProvider helloWorldProvider;
  
  @Inject
  private Event<CrossModuleEvent> event;  
  
  @Override
  public String hello() {
    return helloWorldProvider.hello();
  }
  
  @Override
  public void fireEvent(final String msg) {
    event.fire(new CrossModuleEventImpl(msg));
  }

}
