package com.androidicts.coffesale.domain.producto;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class Producto {

  private String nombre;
  private String identificador;
  private double costo;

  public Producto() {}

  public Producto(String nombre, String identificador, double costo) {

    this.nombre = nombre;
    this.identificador = identificador;
    this.costo = costo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getIdentificador() {
    return identificador;
  }

  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  public double getCosto() {
    return costo;
  }

  public void setCosto(double costo) {
    this.costo = costo;
  }
}
