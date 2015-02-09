package org.jboss.errai.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class AppReady {
  
  private String appId;

  public AppReady() {};
  
  public AppReady(String id) {
    this.appId = id;
  }
  
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

}
