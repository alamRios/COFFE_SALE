package com.androidicts.coffesale.vendedor;

import com.androidicts.coffesale.domain.vendedor.Vendedor;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class VendedorModelDataMapper {

  public static VendedorModel transformar(Vendedor vendedor) {
    if(vendedor == null) {
      throw new IllegalArgumentException("Imposible transformar null");
    }
    VendedorModel vendedorModel = new VendedorModel();
    vendedorModel.setNombre(vendedor.getNombre());
    vendedorModel.setApellidoPaterno(vendedor.getApellidoPaterno());
    vendedorModel.setApellidoMaterno(vendedor.getApellidoMaterno());
    vendedorModel.setCodigoEmpleado(vendedor.getCodigoEmpleado());
    return vendedorModel;
  }
}
