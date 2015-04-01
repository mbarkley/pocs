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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Templated("CrudApp.html#employee")
public class EmployeeListItemWidget extends Composite implements HasModel<Employee> {

  @Inject
  @AutoBound
  private DataBinder<Employee> binder;

  @Bound
  @DataField
  private final Element id = DOM.createTD();

  @Bound
  @DataField
  private final Element firstName = DOM.createTD();
  
  @Bound
  @DataField
  private final Element lastName = DOM.createTD();

  @Bound
  @DataField
  private final Element email = DOM.createTD();

  @Bound
  @DataField
  private final Element hireDate = DOM.createTD();

  @Inject
  @DataField
  private Button edit;
  
  @Inject
  @DataField
  private Button delete;
  
  @Inject
  private EmployeeForm form;
  
  @Inject
  private Caller<EmployeeEndpoint> endpoint;
  
  @EventHandler("edit")
  private void onEdit(ClickEvent e) {
    form.setModel(binder.getModel());
    new ModalForm(form, "Edit Employee", "employeeForm").show();
  }
  
  @EventHandler("delete")
  private void onDelete(ClickEvent e) {
    endpoint.call(new ResponseCallback() {
      @Override
      public void callback(Response response) {
        if (response.getStatusCode() != Response.SC_NO_CONTENT) {
          Window.alert("Server returned wrong status code:" + response.getStatusCode());
        }
      }
    }).delete(binder.getModel().getId());
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