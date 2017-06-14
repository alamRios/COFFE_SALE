package com.androidicts.coffesale.domain.producto;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public interface ProductoRepositorio {

  Observable<List<Producto>> productos();
}
