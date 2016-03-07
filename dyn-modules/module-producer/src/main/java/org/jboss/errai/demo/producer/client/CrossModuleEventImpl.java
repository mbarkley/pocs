package org.jboss.errai.demo.producer.client;

import org.jboss.errai.demo.core.client.CrossModuleEvent;

import jsinterop.annotations.JsType;


@JsType
public class CrossModuleEventImpl implements CrossModuleEvent {

  private String val;
  
  public CrossModuleEventImpl(String val) {
    this.val = val;
  }
  
  @Override
  public String getVal() {
    return val;
  }

}
