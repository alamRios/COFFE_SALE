package com.androidicts.coffeesale.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.androidicts.coffeesale.data.exception.ConexionRedException;
import com.androidicts.coffeesale.data.venta.VentaEntity;
import com.androidicts.coffeesale.data.venta.mapper.VentaEntityJsonMapper;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class RestApiImpl implements RestApi {

  private final Context context;
  private final VentaEntityJsonMapper ventaEntityJsonMapper;

  public RestApiImpl(Context context, VentaEntityJsonMapper ventaEntityJsonMapper) {
    if(context == null || ventaEntityJsonMapper == null) {
      throw new IllegalArgumentException("Los argumentos no pueden ser nulos");
    }
    this.context = context.getApplicationContext();
    this.ventaEntityJsonMapper = ventaEntityJsonMapper;
  }

  @Override public Observable<List<VentaEntity>> ventaEntityList(String cafeteriaId) {
    return Observable.create(e -> {
      if(hayInternet()) {
        try {
          String respuestaVentaEntities = getVentaEntitiesDeApi(cafeteriaId);
          if(respuestaVentaEntities != null) {
            e.onNext(ventaEntityJsonMapper.transformarVentaEntityList(respuestaVentaEntities));
            e.onComplete();
          } else {
            e.onError(new ConexionRedException());
          }
        } catch(Exception ex) {
          e.onError(new ConexionRedException(ex.getCause()));
        }
      } else {
        e.onError(new ConexionRedException());
      }
    });
  }

  private String getVentaEntitiesDeApi(String cafeteriaId) throws MalformedURLException {
    String apiUrl = API_URL_GET_VENTA_LIST + cafeteriaId;
    return ApiConnection.createGET(apiUrl).requestSyncCall();
  }

  private boolean hayInternet() {

    ConnectivityManager connectivityManager =
        (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

    return networkInfo != null && networkInfo.isConnectedOrConnecting();
  }
}
