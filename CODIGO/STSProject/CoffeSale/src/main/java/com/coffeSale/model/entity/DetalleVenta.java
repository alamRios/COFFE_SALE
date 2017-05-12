package com.coffeSale.model.entity;

import java.io.Serializable;

public class DetalleVenta implements Serializable{
	private static final long serialVersionUID = -838827074339573060L;
	
	private int id; 
	private int ventaId; 
	private int productoId;
	private double precioUnitario; 
	
	public DetalleVenta(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleVenta{id=" + id + ", ventaId=" + ventaId
				+ ", productoId=" + productoId + ", precioUnitario="
				+ precioUnitario + "}";
	}
}
