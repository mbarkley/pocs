package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.demo.client.shared.EmployeeEndpoint;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

@Templated
public class EmployeeForm extends Composite implements HasModel<Employee> {

  @Inject
  @AutoBound
  private DataBinder<Employee> binder;

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

  @Inject
  @DataField
  private Button save;

  @Inject
  private Caller<EmployeeEndpoint> endpoint;

  @EventHandler("save")
  private void onSave(ClickEvent e) {
    // TODO proper error handling, cleanup
    if (binder.getModel().getId() == null) {
      endpoint.call(new ResponseCallback() {
        @Override
        public void callback(Response response) {
          if (response.getStatusCode() != Response.SC_CREATED) {
            Window.alert("Server returned wrong status code:" + response.getStatusCode());
          }
          DOM.getElementById("employeeForm").removeFromParent();
        }
      }).create(binder.getModel());
    }
    else {
      endpoint.call(new ResponseCallback() {
        @Override
        public void callback(Response response) {
          if (response.getStatusCode() != Response.SC_OK) {
            Window.alert("Server returned wrong status code:" + response.getStatusCode());
          }
          DOM.getElementById("employeeForm").removeFromParent();
        }
      }).update(binder.getModel().getId(), binder.getModel());
    }
  }

  @Override
  public Employee getModel() {
    return binder.getModel();
  }

  @Override
  public void setModel(Employee model) {
    binder.setModel(model);
  }
  
}