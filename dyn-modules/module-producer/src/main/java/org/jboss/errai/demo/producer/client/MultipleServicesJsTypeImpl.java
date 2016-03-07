package org.jboss.errai.demo.producer.client;

import org.jboss.errai.demo.core.client.MultipleServices;

import jsinterop.annotations.JsType;


@JsType
public class MultipleServicesJsTypeImpl implements MultipleServices {

  @Override
  public String hello() {
    return "JsType hello";
  }

}
