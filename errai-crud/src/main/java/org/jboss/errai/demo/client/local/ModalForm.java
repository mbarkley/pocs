package org.jboss.errai.demo.client.local;

import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalSize;
import org.gwtbootstrap3.client.ui.constants.ModalBackdrop;

import com.google.gwt.user.client.ui.Composite;

public class ModalForm {
  private Modal m = new Modal();
  
  public ModalForm(final Composite composite, final String title, String id) {
    m.setSize(ModalSize.MEDIUM);
    m.setHideOtherModals(true);
    m.setClosable(true);
    
    ModalBody b = new ModalBody();
    b.add(composite);
    
    m.setTitle(title);
    m.add(b);
    
    m.setFade(true);
    m.setDataBackdrop(ModalBackdrop.FALSE);
    m.getElement().setId(id);
  }
  
  public void show() {
    m.show();
  }
  
  public void hide() {
    m.hide();
  }
}
