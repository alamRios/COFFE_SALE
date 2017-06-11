package com.androidicts.coffesale.domain.venta;

import com.androidicts.coffesale.domain.CasoUsoBase;
import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import io.reactivex.Observable;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class ObtenerVentaCasoUso extends CasoUsoBase<Venta, ObtenerVentaCasoUso.Parametros> {

  private final VentaRepositorio ventaRepositorio;

  ObtenerVentaCasoUso(VentaRepositorio ventaRepositorio, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread ) {
    super(threadExecutor, postExecutionThread);
    this.ventaRepositorio = ventaRepositorio;
  }

  @Override
  public Observable<Venta> construirObservableCasoUso(Parametros parametros) {
    return null;
  }

  public static final class Parametros {

  }

}
