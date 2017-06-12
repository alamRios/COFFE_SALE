package com.androidicts.coffesale;

import android.content.Context;
import com.androidicts.coffeesale.data.exception.ConexionRedException;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class MensajeErrorFactory {

  public static String crear(Context context, Exception e) {
    String mensaje = context.getString(R.string.mensaje_excepcion_generico);

    if(e instanceof ConexionRedException) {
      mensaje = context.getString(R.string.mensaje_excepcion_no_conexion);
    }

    return mensaje;
  }
}
