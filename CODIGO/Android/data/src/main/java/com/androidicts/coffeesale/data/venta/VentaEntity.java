package com.androidicts.coffeesale.data.venta;

import com.androidicts.coffeesale.data.gaveta.GavetaEntity;
import com.androidicts.coffeesale.data.producto.ProductoEntity;
import com.androidicts.coffeesale.data.vendedor.VendedorEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public class VentaEntity {

  @SerializedName("vendedor") private VendedorEntity vendedor;
  @SerializedName("gaveta") private GavetaEntity gaveta;
  @SerializedName("montoTotal") private double montoTotal;
  @SerializedName("momentoVenta") private String momentoVenta;
  @SerializedName("productos") private List<ProductoEntity> productos;

  public VendedorEntity getVendedor() {
    return vendedor;
  }

  public void setVendedor(VendedorEntity vendedor) {
    this.vendedor = vendedor;
  }

  public GavetaEntity getGaveta() {
    return gaveta;
  }

  public void setGaveta(GavetaEntity gaveta) {
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

  public List<ProductoEntity> getProductos() {
    return productos;
  }

  public void setProductos(List<ProductoEntity> productos) {
    this.productos = productos;
  }
}
