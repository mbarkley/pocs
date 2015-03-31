package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.client.widget.ValueImage;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Templated("CrudApp.html#employee")
public class EmployeeListItemWidget extends Composite implements HasModel<Employee> {

  @Inject
  @AutoBound
  private DataBinder<Employee> userComplaint;

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
  @Bound
  @DataField
  private ValueImage picture;

  @Inject
  @DataField
  private Button edit;
  
  @Inject
  @DataField
  private Button delete;
  
  @EventHandler("edit")
  private void onEdit(ClickEvent e) {
    Window.alert("edit");
  }
  
  @EventHandler("delete")
  private void onDelete(ClickEvent e) {
    Window.alert("delete");
  }
  
  @Override
  public Employee getModel() {
    return userComplaint.getModel();
  }

  @Override
  public void setModel(Employee model) {
    userComplaint.setModel(model);
  }

}