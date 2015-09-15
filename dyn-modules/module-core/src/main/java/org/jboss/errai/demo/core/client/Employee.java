package org.jboss.errai.demo.core.client;

import java.util.Date;

import com.google.gwt.core.client.js.JsType;

@JsType
public interface Employee {

  Long getId();

  void setId(Long id);

  String getFirstName();

  void setFirstName(String name);

  String getLastName();

  void setLastName(String complaint);

  String getEmail();

  void setEmail(String email);

  Date getHireDate();

  void setHireDate(Date hireDate);

  String getDetailString();
}
