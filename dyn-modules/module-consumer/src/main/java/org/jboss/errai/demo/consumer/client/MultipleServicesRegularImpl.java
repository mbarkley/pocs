package org.jboss.errai.demo.consumer.client;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.errai.demo.core.client.MultipleServices;

@ApplicationScoped
public class MultipleServicesRegularImpl implements MultipleServices {

  @Override
  public String hello() {
    return "regular type hello";
  }

}
