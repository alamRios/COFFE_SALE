package com.androidicts.coffeesale.data.vendedor;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class VendedorEntity {

  @SerializedName("nombre") private String nombre;
  @SerializedName("apPaterno") private String apellidoPaterno;
  @SerializedName("apMaterno") private String apellidoMaterno;
  @SerializedName("codigoEmpleado") private long codigoEmpleado;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public long getCodigoEmpleado() {
    return codigoEmpleado;
  }

  public void setCodigoEmpleado(long codigoEmpleado) {
    this.codigoEmpleado = codigoEmpleado;
  }
}
