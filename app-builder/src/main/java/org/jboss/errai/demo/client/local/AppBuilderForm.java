package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

@Page(role = DefaultPage.class)
@Templated("AppBuilderForm.html#app-template")
public class AppBuilderForm extends Composite {

  @DataField
  private Element appBuilder = DOM.createDiv();
  
  @DataField
  private Element app1 = DOM.createDiv();
  
  @Inject @DataField
  private Button loadApp;
  
  @Inject 
  private AppLoader appLoader;
  
  @EventHandler("loadApp")
  private void onSubmit(ClickEvent e) {
    appLoader.loadApp("app1", "app1-div", "app1-data");
  }
  
}