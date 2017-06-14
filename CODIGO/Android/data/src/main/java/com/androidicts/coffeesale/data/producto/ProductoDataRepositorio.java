package com.androidicts.coffeesale.data.producto;

import com.androidicts.coffeesale.data.producto.mapper.ProductoEntityDataMapper;
import com.androidicts.coffesale.domain.producto.Producto;
import com.androidicts.coffesale.domain.producto.ProductoRepositorio;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

@Singleton
public class ProductoDataRepositorio implements ProductoRepositorio {

  private final ProductoDataStoreFactory productoDataStoreFactory;
  private final ProductoEntityDataMapper productoEntityDataMapper;

  @Inject
  public ProductoDataRepositorio(ProductoDataStoreFactory productoDataStoreFactory,
      ProductoEntityDataMapper productoEntityDataMapper) {
    this.productoDataStoreFactory = productoDataStoreFactory;
    this.productoEntityDataMapper = productoEntityDataMapper;
  }

  @Override public Observable<List<Producto>> productos() {
    final ProductoDataStore productoDataStore = productoDataStoreFactory.crearApiProductoDataStore();
    return productoDataStore.listaProductoEntity().map(ProductoEntityDataMapper::transformar);
  }
}
