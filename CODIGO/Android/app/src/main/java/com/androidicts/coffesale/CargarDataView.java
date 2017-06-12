package com.androidicts.coffesale;

import android.content.Context;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public interface CargarDataView {

  void mostrarCargando();
  void ocultarCargando();
  void mostrarReintentar();
  void ocultarReintentar();
  void mostrarError(String mensaje);
  Context context();
}
