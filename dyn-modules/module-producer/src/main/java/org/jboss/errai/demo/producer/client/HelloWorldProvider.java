package org.jboss.errai.demo.producer.client;

import javax.enterprise.context.Dependent;

@Dependent
public class HelloWorldProvider {
  
  public String hello() {
    return "Hello World!!!";
  }

}
