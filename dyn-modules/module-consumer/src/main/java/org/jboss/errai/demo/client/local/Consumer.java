package org.jboss.errai.demo.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.jboss.errai.demo.client.Employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

@ApplicationScoped
public class Consumer extends Composite {

  @PostConstruct
  private void init() {
    final Button button = new Button("Test");
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        final Employee e = EmployeeFactory.create("Christian", "Sadilek", "csadilek@redhat.com");
        Window.alert(e.getDetailString());
      }

    });
    RootPanel.get().add(button);
  }

}