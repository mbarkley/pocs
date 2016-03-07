package org.jboss.errai.demo.core.client;

import jsinterop.annotations.JsType;

@JsType
public interface AppScopedService {

  String hello();
  
  void fireEvent(String msg);
}
