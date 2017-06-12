package com.androidicts.coffeesale.data.vendedor.mapper;

import com.androidicts.coffeesale.data.vendedor.VendedorEntity;
import com.androidicts.coffesale.domain.vendedor.Vendedor;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class VendedorEntityDataMapper {

  public static Vendedor transformar(VendedorEntity vendedorEntity) {
    Vendedor vendedor = null;
    if(vendedorEntity != null) {
      vendedor = new Vendedor();
      vendedor.setNombre(vendedorEntity.getNombre());
      vendedor.setApellidoPaterno(vendedorEntity.getApellidoPaterno());
      vendedor.setApellidoMaterno(vendedorEntity.getApellidoMaterno());
      vendedor.setCodigoEmpleado(vendedorEntity.getCodigoEmpleado());
    }
    return vendedor;
  }

}
