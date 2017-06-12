package com.androidicts.coffeesale.data.producto.mapper;

import com.androidicts.coffeesale.data.producto.ProductoEntity;
import com.androidicts.coffesale.domain.producto.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class ProductoEntityDataMapper {

  public static Producto transformar(ProductoEntity productoEntity) {
    Producto producto = null;
    if(productoEntity != null) {
      producto = new Producto();
      producto.setCosto(productoEntity.getCosto());
      producto.setIdentificador(productoEntity.getIdentificador());
      producto.setNombre(productoEntity.getNombre());
    }
    return producto;
  }

  public static List<Producto> transformar(Collection<ProductoEntity> productoEntityCollection) {
    final List<Producto> productoList = new ArrayList<>();
    for(ProductoEntity productoEntity: productoEntityCollection) {
      Producto producto = transformar(productoEntity);
      if(producto != null) {
        productoList.add(producto);
      }
    }
    return productoList;
  }

}
