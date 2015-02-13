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
package org.jboss.errai.cdi.demo.mvp.client.local;

import org.jboss.errai.cdi.demo.mvp.client.local.event.AddContactEvent;
import org.jboss.errai.cdi.demo.mvp.client.local.event.AddContactEventHandler;
import org.jboss.errai.cdi.demo.mvp.client.local.event.ContactUpdatedEvent;
import org.jboss.errai.cdi.demo.mvp.client.local.event.ContactUpdatedEventHandler;
import org.jboss.errai.cdi.demo.mvp.client.local.event.EditContactCancelledEvent;
import org.jboss.errai.cdi.demo.mvp.client.local.event.EditContactCancelledEventHandler;
import org.jboss.errai.cdi.demo.mvp.client.local.event.EditContactEvent;
import org.jboss.errai.cdi.demo.mvp.client.local.event.EditContactEventHandler;
import org.jboss.errai.cdi.demo.mvp.client.local.presenter.ContactsPresenter;
import org.jboss.errai.cdi.demo.mvp.client.local.presenter.Presenter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

  private HandlerManager eventBus = new HandlerManager(null);

  private HasWidgets container;

  public void bind() {
    History.addValueChangeHandler(this);

    eventBus.addHandler(AddContactEvent.TYPE, new AddContactEventHandler() {
      public void onAddContact(AddContactEvent event) {
        doAddNewContact();
      }
    });

    eventBus.addHandler(EditContactEvent.TYPE, new EditContactEventHandler() {
      public void onEditContact(EditContactEvent event) {
        doEditContact(event.getId());
      }
    });

    eventBus.addHandler(EditContactCancelledEvent.TYPE,
            new EditContactCancelledEventHandler() {
              public void onEditContactCancelled(EditContactCancelledEvent event) {
                doEditContactCancelled();
              }
            });

    eventBus.addHandler(ContactUpdatedEvent.TYPE,
            new ContactUpdatedEventHandler() {
              public void onContactUpdated(ContactUpdatedEvent event) {
                doContactUpdated();
              }
            });
  }

  private void doAddNewContact() {
    History.newItem("add");
  }

  private void doEditContact(String id) {
   
  }

  private void doEditContactCancelled() {
    History.newItem("list");
  }

  private void doContactUpdated() {
    History.newItem("list");
  }

  public void go(final HasWidgets container) {
    this.container = container;
    bind();

    new ContactsPresenter().go(container);
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();
    if (token != null) {
      Presenter presenter = null;

      if (token.equals("list")) {
        presenter = new ContactsPresenter();
      }
      else if (token.equals("add") || token.equals("edit")) {
      }

      if (presenter != null) {
        presenter.go(container);
      }
    }
  }
}