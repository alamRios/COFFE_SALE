package com.androidicts.coffeesale.data.venta.mapper;

import com.androidicts.coffeesale.data.venta.VentaEntity;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class VentaEntityJsonMapper {

  private final Gson gson;

  @Inject
  public VentaEntityJsonMapper() {
    this.gson = new Gson();
  }

  public List<VentaEntity> transformarVentaEntityList(String ventaJsonResponse)
      throws JsonSyntaxException{
    final Type listaVentaEntityListType = new TypeToken<List<VentaEntity>>() {}.getType();
    return gson.fromJson(ventaJsonResponse, listaVentaEntityListType);
  }
}
