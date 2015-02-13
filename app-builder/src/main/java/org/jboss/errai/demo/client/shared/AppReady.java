package org.jboss.errai.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class AppReady {
  
  private String appId;
  private String url;
  
  public AppReady() {};
  
  public AppReady(String id, String url) {
    this.appId = id;
    this.url = url;
  }
  
  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
