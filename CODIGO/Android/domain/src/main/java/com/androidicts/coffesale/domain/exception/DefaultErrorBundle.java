package com.androidicts.coffesale.domain.exception;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class DefaultErrorBundle implements ErrorBundle {

  private static final String MSJ_ERROR_DEFAULT = "Error desconocido";

  private final Exception exception;

  public DefaultErrorBundle(Exception exception) {
    this.exception = exception;
  }

  @Override public Exception getException() {
    return exception;
  }

  @Override public String getMensajeError() {
    return (exception != null) ? exception.getMessage() : MSJ_ERROR_DEFAULT;
  }
}
