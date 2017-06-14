package com.androidicts.coffesale.di.componente;

import android.content.Context;
import com.androidicts.coffesale.BaseActivity;
import com.androidicts.coffesale.di.modulo.AplicacionModulo;
import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import com.androidicts.coffesale.domain.producto.ProductoRepositorio;
import com.androidicts.coffesale.domain.venta.VentaRepositorio;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Singleton
@Component(modules = AplicacionModulo.class)
public interface AplicacionComponente {

  void inject(BaseActivity baseActivity);

  //Expuesto a los subgrafos
  Context context();
  ThreadExecutor threadExecutor();
  PostExecutionThread postExecutionThread();
  VentaRepositorio ventaRepositorio();
  ProductoRepositorio productoRepositorio();
}
