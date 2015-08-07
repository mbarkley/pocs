package org.jboss.errai.demo.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.demo.client.AppScopedService;
import org.jboss.errai.demo.client.Employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

@ApplicationScoped
public class Consumer extends Composite {

  // Injecting an instance of a type provided by a different script at runtime
  // (not known/inherited in this GWT module) (see dyn-modules/module-producer)
  @Inject
  private AppScopedService service;

  @PostConstruct
  private void init() {
    final Button button = new Button("Test");
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        Window.alert(service.hello());

        // Creation of an instance of a type provided by a different script at
        // runtime (not known/inherited in this GWT module) (see
        // dyn-modules/module-producer)
        final Employee e = EmployeeFactory.create("Christian", "Sadilek", "csadilek@redhat.com");
        Window.alert(e.getDetailString());
      }
    });
    RootPanel.get().add(button);
  }

}