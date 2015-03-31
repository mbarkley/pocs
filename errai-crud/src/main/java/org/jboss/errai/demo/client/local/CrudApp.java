package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalComponent;
import org.gwtbootstrap3.client.ui.ModalSize;
import org.gwtbootstrap3.client.ui.constants.ModalBackdrop;
import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.ui.client.widget.ListWidget;
import org.jboss.errai.ui.client.widget.Table;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Page(role = DefaultPage.class)
@Templated
public class CrudApp extends Composite {
  
  @Inject
  private EmployeeForm form;

  @Inject @DataField
  private Button create;
  
  @Inject @DataField @Table(root="tbody") 
  private ListWidget<Employee, EmployeeListItemWidget> employees;

  @EventHandler("create")
  private void onCreate(ClickEvent e) {
    Modal m = new Modal();
    m.setSize(ModalSize.MEDIUM);
    m.setHideOtherModals(true);
    m.setClosable(true);
    
    ModalBody b = new ModalBody();
    b.add(form);
    
    m.setTitle("Create new Employee");
    m.add(b);
    
    m.setFade(true);
    m.setDataBackdrop(ModalBackdrop.FALSE);
    m.show();
  }
  
}