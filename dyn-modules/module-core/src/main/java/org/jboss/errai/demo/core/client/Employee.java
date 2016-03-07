package org.jboss.errai.demo.core.client;

import jsinterop.annotations.JsType;

@JsType(namespace="Core")
public interface Employee {

  int getId();

  void setId(int id);

  String getFirstName();

  void setFirstName(String name);

  String getLastName();

  void setLastName(String complaint);

  String getEmail();

  void setEmail(String email);

  String getDetailString();
}
