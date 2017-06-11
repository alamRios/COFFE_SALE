package com.androidicts.coffeesale.data.venta;

import com.androidicts.coffeesale.data.RestApi;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class ApiVentaDataStore implements VentaDataStore {

  private final RestApi restApi;

  public ApiVentaDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override public Observable<List<VentaEntity>> listaVentaEntity(String cafeteriaId) {
    return restApi.ventaEntityList(cafeteriaId);
  }

  @Override public Observable<VentaEntity> ventaEntityDetalle() {
    return null;
  }
}
