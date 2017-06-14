package com.androidicts.coffeesale.data.producto.mapper;

import com.androidicts.coffeesale.data.producto.ProductoEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public class ProductoEntityJsonMapper {

  private final Gson gson;

  @Inject
  public ProductoEntityJsonMapper() {
    this.gson = new Gson();
  }

  public List<ProductoEntity> transformarProductoEntityList(String productoJsonResponse)
    throws JsonSyntaxException {
    final Type listaProductoEntityListType = new TypeToken<List<ProductoEntity>>() {}.getType();
    return gson.fromJson(productoJsonResponse, listaProductoEntityListType);
  }
}
