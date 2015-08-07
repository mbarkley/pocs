package org.jboss.errai.demo.client.impl;

import javax.enterprise.context.Dependent;

@Dependent
public class HelloWorldProvider {
  
  public String hello() {
    return "Hello World!!!";
  }

}
