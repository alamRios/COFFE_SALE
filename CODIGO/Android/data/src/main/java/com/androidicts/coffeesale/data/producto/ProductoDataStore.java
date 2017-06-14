package com.androidicts.coffeesale.data.producto;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public interface ProductoDataStore {

  Observable<List<ProductoEntity>> listaProductoEntity();

}
