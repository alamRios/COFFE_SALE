package com.androidicts.coffesale.domain.venta;

import com.androidicts.coffesale.domain.CasoUsoBase;
import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class ObtenerVentasCasoUso extends CasoUsoBase<List<Venta>, String> {

  private final VentaRepositorio ventaRepositorio;

  @Inject
  protected ObtenerVentasCasoUso(VentaRepositorio ventaRepositorio, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.ventaRepositorio = ventaRepositorio;
  }

  @Override public Observable<List<Venta>> construirObservableCasoUso(String cafeteriaId) {
    return ventaRepositorio.ventas(cafeteriaId);
  }
}
