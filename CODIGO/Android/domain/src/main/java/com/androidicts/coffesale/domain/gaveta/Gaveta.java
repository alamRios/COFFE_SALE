package com.androidicts.coffesale.domain.gaveta;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class Gaveta {

  private long fondo;
  private double capacidad;

  public Gaveta() {}

  public Gaveta(long fondo, double capacidad) {
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
