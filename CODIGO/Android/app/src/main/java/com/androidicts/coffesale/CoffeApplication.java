package com.androidicts.coffesale;

import android.app.Application;
import com.androidicts.coffesale.di.componente.AplicacionComponente;
import com.androidicts.coffesale.di.componente.DaggerAplicacionComponente;
import com.androidicts.coffesale.di.modulo.AplicacionModulo;
import timber.log.Timber;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class CoffeApplication extends Application {

  private AplicacionComponente aplicacionComponente;

  @Override public void onCreate() {
    super.onCreate();
    this.inicializarInyector();
    Timber.plant(new Timber.DebugTree());
  }

  private void inicializarInyector() {
    aplicacionComponente = DaggerAplicacionComponente.builder()
        .aplicacionModulo(new AplicacionModulo(this))
        .build();
  }

  public AplicacionComponente getAplicacionComponente() {
    return aplicacionComponente;
  }
}
