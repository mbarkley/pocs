package org.jboss.errai.demo.client;

import java.util.Date;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface Employee {

  @JsProperty
  Long getId();

  @JsProperty
  void setId(Long id);

  @JsProperty
  String getFirstName();

  @JsProperty
  void setFirstName(String name);

  @JsProperty
  String getLastName();

  @JsProperty
  void setLastName(String complaint);

  @JsProperty
  String getEmail();

  @JsProperty
  void setEmail(String email);

  @JsProperty
  Date getHireDate();

  @JsProperty
  void setHireDate(Date hireDate);

}
