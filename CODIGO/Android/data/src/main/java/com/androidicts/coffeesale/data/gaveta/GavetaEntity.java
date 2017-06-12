package com.androidicts.coffeesale.data.gaveta;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class GavetaEntity {

  @SerializedName("fondo") private long fondo;
  @SerializedName("capacidad") private double capacidad;

  public long getFondo() {
    return fondo;
  }

  public void setFondo(long fondo) {
    this.fondo = fondo;
  }

  public double getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(double capacidad) {
    this.capacidad = capacidad;
  }
}
