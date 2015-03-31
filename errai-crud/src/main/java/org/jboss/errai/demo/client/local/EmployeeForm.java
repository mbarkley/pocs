package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.demo.client.shared.EmployeeEndpoint;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.ui.client.widget.ValueImage;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Model;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

@Templated
public class EmployeeForm extends Composite {

  @Inject
  @Model
  private Employee employee;

  @Inject
  @Bound
  @DataField
  private TextBox firstName;

  @Inject
  @Bound
  @DataField
  private TextBox lastName;
  
  @Inject
  @Bound
  @DataField
  private TextBox email;
  
  @Inject
  @Bound
  @DataField
  private DatePicker hireDate;

//  @Inject
//  @Bound
//  @DataField
//  private ValueImage picture;

  @Inject
  @DataField
  private Button save;

  @Inject
  private Caller<EmployeeEndpoint> endpoint;

  @EventHandler("save")
  private void onSave(ClickEvent e) {
    endpoint.call(new ResponseCallback() {
      @Override
      public void callback(Response response) {
        if (response.getStatusCode() == Response.SC_CREATED) {
        }
      }
    }).create(employee);
  }
}