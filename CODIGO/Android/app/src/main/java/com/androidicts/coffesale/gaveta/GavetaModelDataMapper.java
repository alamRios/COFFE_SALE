package com.androidicts.coffesale.gaveta;

import com.androidicts.coffesale.domain.gaveta.Gaveta;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class GavetaModelDataMapper {

  public static GavetaModel transformar(Gaveta gaveta) {
    if(gaveta == null) {
      throw new IllegalArgumentException("Imposible transformar null");
    }
    GavetaModel gavetaModel = new GavetaModel();
    gavetaModel.setFondo(gaveta.getFondo());
    gavetaModel.setCapacidad(gaveta.getCapacidad());
    return gavetaModel;
  }
}
