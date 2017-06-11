package com.androidicts.coffeesale.data.venta;

import com.androidicts.coffeesale.data.venta.mapper.VentaEntityDataMapper;
import com.androidicts.coffesale.domain.venta.Venta;
import com.androidicts.coffesale.domain.venta.VentaRepositorio;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

@Singleton
public class VentaDataRepositorio implements VentaRepositorio{

  private final VentaDataStoreFactory ventaDataStoreFactory;
  private final VentaEntityDataMapper ventaEntityDataMapper;

  @Inject
  public VentaDataRepositorio(VentaDataStoreFactory ventaDataStoreFactory,
      VentaEntityDataMapper ventaEntityDataMapper) {
    this.ventaDataStoreFactory = ventaDataStoreFactory;
    this.ventaEntityDataMapper = ventaEntityDataMapper;
  }

  @Override public Observable<List<Venta>> ventas() {
    return null;
  }

  @Override public Observable<Venta> venta() {
    return null;
  }
}
