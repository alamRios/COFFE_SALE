package com.androidicts.coffeesale.data.venta;

import android.content.Context;
import com.androidicts.coffeesale.data.RestApi;
import com.androidicts.coffeesale.data.RestApiImpl;
import com.androidicts.coffeesale.data.venta.mapper.VentaEntityJsonMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

@Singleton
public class VentaDataStoreFactory {

  private final Context context;

  @Inject
  public VentaDataStoreFactory(Context context) {
    this.context = context;
  }

  public VentaDataStore crearApiDataStore() {
    final VentaEntityJsonMapper ventaEntityJsonMapper = new VentaEntityJsonMapper();
    final RestApi restApi = new RestApiImpl(context, ventaEntityJsonMapper);

    return new ApiVentaDataStore(restApi);
  }
}
