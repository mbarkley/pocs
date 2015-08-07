package org.jboss.errai.demo.client.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.demo.client.AppScopedService;

import com.google.gwt.core.client.js.JsType;

@JsType
@ApplicationScoped
public class AppScopedServiceImpl implements AppScopedService {

  @Inject
  private HelloWorldProvider helloWorldProvider;
  
  @Override
  public String hello() {
    return helloWorldProvider.hello();
  }

}
