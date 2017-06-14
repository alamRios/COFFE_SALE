package com.androidicts.coffesale;

import android.content.Context;
import android.content.Intent;
import com.androidicts.coffesale.producto.ProductoActivity;
import com.androidicts.coffesale.venta.VentaListActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Singleton
public class Navegador {

  @Inject
  public Navegador() {
  }

  public void navegarAListaVentas(Context context) {
    if(context != null) {
      Intent intent = VentaListActivity.getCallingIntent(context);
      context.startActivity(intent);
    }
  }

  public void navegarAListaProductos(Context context) {
    if(context != null) {
      Intent intent = ProductoActivity.getCallingIntent(context);
      context.startActivity(intent);
    }
  }
}
