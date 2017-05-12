package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;

public class InventarioDTO {
	private Date fechaCreacion;
	private String codigoInventario;
	private ArrayList<ProductoDTO> productos;
	
	public InventarioDTO(){
		this(new Date(), "", new ArrayList<ProductoDTO>());
	}
	public InventarioDTO(Date fechaCreacion, String codigoInventario,
			ArrayList<ProductoDTO> productos) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.codigoInventario = codigoInventario;
		this.productos = productos;
	}
	public InventarioDTO(InventarioDTO inventario){
		this(
			inventario.fechaCreacion,
			inventario.codigoInventario,
			inventario.productos
		);
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigoInventario() {
		return codigoInventario;
	}

	public void setCodigoInventario(String codigoInventario) {
		this.codigoInventario = codigoInventario;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Inventario [fechaCreacion=" + fechaCreacion
				+ ", codigoInventario=" + codigoInventario + ", productos="
				+ productos + "]";
	} 
}
