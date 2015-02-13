/**
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.errai.cdi.demo.mvp.client.local.presenter;

import java.util.ArrayList;
import java.util.List;

import org.jboss.errai.cdi.demo.mvp.client.local.view.ContactsView;
import org.jboss.errai.cdi.demo.mvp.client.shared.Contact;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ContactsPresenter implements Presenter {

  public interface Display {
    HasClickHandlers getAddButton();

    HasClickHandlers getDeleteButton();

    HasClickHandlers getList();

    void setData(List<String> data);

    int getClickedRow(ClickEvent event);

    List<Integer> getSelectedRows();

    Widget asWidget();
  }

  private Display display = new ContactsView();

  public void bind() {
    
  }

  public void go(final HasWidgets container) {
    bind();
    container.clear();
    container.add(display.asWidget());
    fetchContacts();
  }

  private void fetchContacts() {
    List<String> data = new ArrayList<String>();
    JsArray<Contact> cs = getContacts();
    for (int i = 0, n = cs.length(); i < n; ++i) {
      data.add(cs.get(i).getFullName());
    }
    display.setData(data);
  }

  private final native JsArray<Contact> getContacts() /*-{
    return $wnd.app_data["app1-data"];
  }-*/;
  
  private void deleteSelectedContacts() {

  }
}