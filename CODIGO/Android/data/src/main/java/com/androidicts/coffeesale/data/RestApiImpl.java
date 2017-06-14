package com.androidicts.coffeesale.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.androidicts.coffeesale.data.exception.ConexionRedException;
import com.androidicts.coffeesale.data.producto.ProductoEntity;
import com.androidicts.coffeesale.data.producto.mapper.ProductoEntityJsonMapper;
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
  private final ProductoEntityJsonMapper productoEntityJsonMapper;

  public RestApiImpl(Context context, VentaEntityJsonMapper ventaEntityJsonMapper,
      ProductoEntityJsonMapper productoEntityJsonMapper) {
    if(context == null || ventaEntityJsonMapper == null || productoEntityJsonMapper == null) {
      throw new IllegalArgumentException("Los argumentos no pueden ser nulos");
    }
    this.context = context.getApplicationContext();
    this.ventaEntityJsonMapper = ventaEntityJsonMapper;
    this.productoEntityJsonMapper = productoEntityJsonMapper;
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

  @Override public Observable<List<ProductoEntity>> productoEntityList() {
    return Observable.create(e -> {
      if(hayInternet()) {
        try {
          String respuestaProductoEntities = getProductoEntitiesDeApi();
          if(respuestaProductoEntities != null) {
            e.onNext(productoEntityJsonMapper.transformarProductoEntityList(respuestaProductoEntities));
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

  private String getProductoEntitiesDeApi() throws MalformedURLException{
    return ApiConnection.createGET(API_URL_GET_PRODUCTO_LIST).requestSyncCall();
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
