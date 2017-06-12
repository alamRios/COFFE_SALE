package com.androidicts.coffesale.venta;

import com.androidicts.coffesale.gaveta.GavetaModel;
import com.androidicts.coffesale.producto.ProductoModel;
import com.androidicts.coffesale.vendedor.VendedorModel;
import java.util.List;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class VentaModel {

  private VendedorModel vendedor;
  private GavetaModel gaveta;
  private double montoTotal;
  private String momentoVenta;
  private List<ProductoModel> productos;

  public VentaModel(VendedorModel vendedor, GavetaModel gaveta, double montoTotal,
      String momentoVenta, List<ProductoModel> productos) {
    this.vendedor = vendedor;
    this.gaveta = gaveta;
    this.montoTotal = montoTotal;
    this.momentoVenta = momentoVenta;
    this.productos = productos;
  }

  public VentaModel() {}

  public VendedorModel getVendedor() {
    return vendedor;
  }

  public void setVendedor(VendedorModel vendedor) {
    this.vendedor = vendedor;
  }

  public GavetaModel getGaveta() {
    return gaveta;
  }

  public void setGaveta(GavetaModel gaveta) {
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

  public List<ProductoModel> getProductos() {
    return productos;
  }

  public void setProductos(List<ProductoModel> productos) {
    this.productos = productos;
  }
}
