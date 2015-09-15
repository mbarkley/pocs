package org.jboss.errai.demo.producer.client;

import java.util.Date;

import com.google.gwt.core.client.js.JsExport;
import com.google.gwt.core.client.js.JsNamespace;
import com.google.gwt.core.client.js.JsType;

@JsType
@JsNamespace("Core")
public class Employee implements org.jboss.errai.demo.core.client.Employee {
  
  private Long id;

  private String firstName;

  private String lastName;
  
  private String email;
  
  private Date hireDate;

  private Employee(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
  
  @JsExport
  public static Employee create(String firstName, String lastName, String email) {
    return new Employee(firstName, lastName, email);
  }
  
  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String name) {
    this.firstName = name;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String complaint) {
    this.lastName = complaint;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public Date getHireDate() {
    return hireDate;
  }

  @Override
  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Employee other = (Employee) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    }
    else if (!email.equals(other.email))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    }
    else if (!firstName.equals(other.firstName))
      return false;
    if (hireDate == null) {
      if (other.hireDate != null)
        return false;
    }
    else if (!hireDate.equals(other.hireDate))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    }
    else if (!id.equals(other.id))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    }
    else if (!lastName.equals(other.lastName))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "EmployeeImpl [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
            + ", email=" + email + ", hireDate=" + hireDate + "]";
  }

  @Override
  public String getDetailString() {
    return getFirstName() + " " + getLastName() + ":" + getEmail();
  }

}