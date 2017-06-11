package com.androidicts.coffesale.di.modulo;

import android.content.Context;
import com.androidicts.coffeesale.data.executor.JobExecutor;
import com.androidicts.coffeesale.data.venta.VentaDataRepositorio;
import com.androidicts.coffesale.CoffeApplication;
import com.androidicts.coffesale.UIThread;
import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import com.androidicts.coffesale.domain.venta.VentaRepositorio;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Module
public class AplicacionModulo {

  private final CoffeApplication coffeApplication;

  public AplicacionModulo(CoffeApplication coffeApplication) {
    this.coffeApplication = coffeApplication;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.coffeApplication;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton VentaRepositorio provideVentaRepositorio(VentaDataRepositorio ventaDataRepositorio) {
    return ventaDataRepositorio;
  }
}
