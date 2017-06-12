package com.androidicts.coffeesale.data.gaveta.mapper;

import com.androidicts.coffeesale.data.gaveta.GavetaEntity;
import com.androidicts.coffesale.domain.gaveta.Gaveta;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class GavetaEntityDataMapper {

  public static Gaveta transformar(GavetaEntity gavetaEntity) {
    Gaveta gaveta = null;
    if(gavetaEntity != null) {
      gaveta = new Gaveta();
      gaveta.setCapacidad(gavetaEntity.getCapacidad());
      gaveta.setFondo(gavetaEntity.getFondo());
    }
    return gaveta;
  }

}
