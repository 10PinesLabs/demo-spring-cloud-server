package com.tenpines.ejemplo.config.server.rest.exceptions;


public class InvalidRequestException extends RuntimeException {
  private String errorCode;

  public InvalidRequestException(String code, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = code;
  }

  public InvalidRequestException(String code, String message) {
    super(message);
    this.errorCode = code;
  }

  public String getErrorCode() {
    return errorCode;
  }
}
