package com.tenpines.ejemplo.config.server.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
  private String errorCode;
  private Object details;
  private String className;

  public ErrorResponse(String errorCode, String className, Object details) {
    this.errorCode = errorCode;
    this.details = details;
    this.className = className;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public Object getDetails() {
    return details;
  }

  public void setDetails(Object details) {
    this.details = details;
  }
}
