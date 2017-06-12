package com.androidicts.coffesale.gaveta;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class GavetaModel {

  private long fondo;
  private double capacidad;

  public GavetaModel() {}

  public GavetaModel(long fondo, double capacidad) {
    this.fondo = fondo;
    this.capacidad = capacidad;
  }

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
