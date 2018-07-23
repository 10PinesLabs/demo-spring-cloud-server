package com.tenpines.ejemplo.config.server.rest;

import com.tenpines.ejemplo.config.server.rest.exceptions.GlobalErrorCodes;
import com.tenpines.ejemplo.config.server.rest.exceptions.InvalidRequestException;
import com.tenpines.ejemplo.config.server.rest.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@ControllerAdvice
public class ErrorHandler {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse requestInvalido(InvalidRequestException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse methodNotSupported(HttpRequestMethodNotSupportedException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse mediaTypeError(HttpMediaTypeException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse errorParseoMensaje(HttpMessageConversionException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse multipartError(MultipartException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse multipartMissing(MissingServletRequestPartException e) {
    return crearError(GlobalErrorCodes.INVALID, e);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse errorInesperado(Throwable e) {
    logger.error("Error inesperado procesando request REST", e);
    return crearError(GlobalErrorCodes.INTERNAL, e);
  }

  private ErrorResponse crearError(String codigo, Throwable e) {
    return new ErrorResponse(codigo, e.getClass().getSimpleName(), e.getMessage());
  }
}
