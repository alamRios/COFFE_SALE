package com.androidicts.coffeesale.data;

import com.androidicts.coffeesale.data.venta.VentaEntity;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public interface RestApi {
  String API_BASE_URL = "http://coffesale.herokuapp.com/rest/";

  String API_URL_GET_VENTA_LIST = API_BASE_URL + "ventas/";

  Observable<List<VentaEntity>> ventaEntityList(final String cafeteriaId);

}
