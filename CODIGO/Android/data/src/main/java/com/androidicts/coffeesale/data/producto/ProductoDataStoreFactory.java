package com.androidicts.coffeesale.data.producto;

import android.content.Context;
import com.androidicts.coffeesale.data.RestApi;
import com.androidicts.coffeesale.data.RestApiImpl;
import com.androidicts.coffeesale.data.producto.mapper.ProductoEntityJsonMapper;
import com.androidicts.coffeesale.data.venta.mapper.VentaEntityJsonMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

@Singleton
public class ProductoDataStoreFactory {

  private Context context;

  @Inject
  public ProductoDataStoreFactory(Context context) {
    this.context = context;
  }

  public ProductoDataStore crearApiProductoDataStore() {
    final VentaEntityJsonMapper ventaEntityJsonMapper = new VentaEntityJsonMapper();
    final ProductoEntityJsonMapper productoEntityJsonMapper = new ProductoEntityJsonMapper();
    final RestApi restApi = new RestApiImpl(context, ventaEntityJsonMapper,
        productoEntityJsonMapper);

    return new ApiProductoDataStore(restApi);
  }
}
