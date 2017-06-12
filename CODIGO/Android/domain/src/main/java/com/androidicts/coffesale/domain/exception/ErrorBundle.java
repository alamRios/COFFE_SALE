package com.androidicts.coffesale.domain.exception;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public interface ErrorBundle {

  Exception getException();
  String getMensajeError();
}
