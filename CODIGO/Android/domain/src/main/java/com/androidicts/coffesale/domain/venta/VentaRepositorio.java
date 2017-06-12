package com.androidicts.coffesale.domain.venta;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public interface VentaRepositorio {

  Observable<List<Venta>> ventas(String cafeteriaId);

  Observable<Venta> venta();
}
