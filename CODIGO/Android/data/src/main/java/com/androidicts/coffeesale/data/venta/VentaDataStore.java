package com.androidicts.coffeesale.data.venta;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public interface VentaDataStore {

  Observable<List<VentaEntity>> listaVentaEntity(final String cafeteriaId);

  Observable<VentaEntity> ventaEntityDetalle();
}
