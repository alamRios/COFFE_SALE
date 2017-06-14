package com.androidicts.coffesale.domain.producto;

import com.androidicts.coffesale.domain.CasoUsoBase;
import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public class ObtenerProductosCasoUso extends CasoUsoBase<List<Producto>, Void> {

  private final ProductoRepositorio productoRepositorio;

  @Inject
  protected ObtenerProductosCasoUso(ProductoRepositorio productoRepositorio,
      ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.productoRepositorio = productoRepositorio;
  }

  @Override public Observable<List<Producto>> construirObservableCasoUso(Void sinUsar) {
    return productoRepositorio.productos();
  }
}
