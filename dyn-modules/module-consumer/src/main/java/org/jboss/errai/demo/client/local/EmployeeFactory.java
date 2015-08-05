package org.jboss.errai.demo.client.local;

import org.jboss.errai.demo.client.Employee;

public class EmployeeFactory {

  public static native Employee create(final String firstName, final String lastName, final String email)  /*-{
    return $wnd.Core.Employee.create(firstName, lastName, email);
  }-*/;
}
