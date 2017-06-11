package com.androidicts.coffesale.domain.venta;

import com.androidicts.coffesale.domain.gaveta.Gaveta;
import com.androidicts.coffesale.domain.producto.Producto;
import com.androidicts.coffesale.domain.vendedor.Vendedor;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class Venta {

  private Vendedor vendedor;
  private Gaveta gaveta;
  private double montoTotal;
  private String momentoVenta;
  private List<Producto> productos;

  public Venta() {}

  public Venta(Vendedor vendedor, Gaveta gaveta, double montoTotal, String momentoVenta,
      List<Producto> productos) {
    this.vendedor = vendedor;
    this.gaveta = gaveta;
    this.montoTotal = montoTotal;
    this.momentoVenta = momentoVenta;
    this.productos = productos;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }

  public Vendedor getVendedor() {
    return vendedor;
  }

  public void setVendedor(Vendedor vendedor) {
    this.vendedor = vendedor;
  }

  public Gaveta getGaveta() {
    return gaveta;
  }

  public void setGaveta(Gaveta gaveta) {
    this.gaveta = gaveta;
  }

  public double getMontoTotal() {
    return montoTotal;
  }

  public void setMontoTotal(double montoTotal) {
    this.montoTotal = montoTotal;
  }

  public String getMomentoVenta() {
    return momentoVenta;
  }

  public void setMomentoVenta(String momentoVenta) {
    this.momentoVenta = momentoVenta;
  }
}
