package org.jboss.errai.demo.producer.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.errai.demo.core.client.CrossModuleEvent;

import com.google.gwt.user.client.Window;

@ApplicationScoped
public class EventObserver {
  
  public void onEvent(@Observes CrossModuleEvent e) {
    Window.alert("Producer got: " + e.getVal());
  }
  
}
