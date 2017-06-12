package com.androidicts.coffeesale.data.producto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class ProductoEntity {

  @SerializedName("nombre") private String nombre;
  @SerializedName("identificador") private String identificador;
  @SerializedName("costo") private double costo;

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
