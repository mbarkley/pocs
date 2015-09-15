package org.jboss.errai.demo.core.client;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface AppScopedService {

  String hello();
  
  void fireEvent(String msg);
}
