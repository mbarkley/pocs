package org.jboss.errai.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class AppError {

  private String message;

  public AppError() {
  };

  public AppError(String msg) {
    this.message = msg;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
