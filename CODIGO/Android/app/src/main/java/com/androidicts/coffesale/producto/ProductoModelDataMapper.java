package com.androidicts.coffesale.producto;

import com.androidicts.coffesale.domain.producto.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class ProductoModelDataMapper {

  public static ProductoModel transformar(Producto producto) {
    if(producto == null) {
      throw new IllegalArgumentException("Imposible transformar null");
    }

    final ProductoModel productoModel = new ProductoModel();
    productoModel.setNombre(producto.getNombre());
    productoModel.setCosto(producto.getCosto());
    productoModel.setIdentificador(producto.getIdentificador());

    return productoModel;
  }

  public static List<ProductoModel> transformar(List<Producto>productoCollection) {
    if(productoCollection == null || productoCollection.isEmpty()) {
      return Collections.emptyList();
    }
    List<ProductoModel> productoModelCollection = new ArrayList<>();
    for(Producto producto: productoCollection) {
      productoModelCollection.add(transformar(producto));
    }
    return productoModelCollection;
  }
}
