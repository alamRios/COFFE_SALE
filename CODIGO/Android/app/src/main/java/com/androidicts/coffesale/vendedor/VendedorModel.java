package com.androidicts.coffesale.vendedor;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class VendedorModel {

  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private long codigoEmpleado;

  public VendedorModel(String nombre, String apellidoPaterno, String apellidoMaterno,
      long codigoEmpleado) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.codigoEmpleado = codigoEmpleado;
  }

  public VendedorModel() {}

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
