package com.androidicts.coffeesale.data.producto;

import com.androidicts.coffeesale.data.RestApi;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public class ApiProductoDataStore implements ProductoDataStore {

  private final RestApi restApi;

  public ApiProductoDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override public Observable<List<ProductoEntity>> listaProductoEntity() {
    return restApi.productoEntityList();
  }
}
