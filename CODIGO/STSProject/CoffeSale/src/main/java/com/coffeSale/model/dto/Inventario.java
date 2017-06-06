package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;

public class Inventario {
	private Date fechaCreacion;
	private String codigoInventario;
	private ArrayList<Producto> productos;
	
	public Inventario(){
		this(new Date(), "", new ArrayList<Producto>());
	}
	public Inventario(Date fechaCreacion, String codigoInventario,
			ArrayList<Producto> productos) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.codigoInventario = codigoInventario;
		this.productos = productos;
	}
	public Inventario(Inventario inventario){
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

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Inventario [fechaCreacion=" + fechaCreacion
				+ ", codigoInventario=" + codigoInventario + ", productos="
				+ productos + "]";
	} 
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Inventario){
				Inventario inventario = (Inventario) obj; 
				if(inventario.codigoInventario.equals(this.codigoInventario)
					&& inventario.fechaCreacion.equals(this.fechaCreacion)){
					for(Producto producto : inventario.productos)
						if(!this.productos.contains(producto))
							return false; 
					return true; 
				}
			}
		}
		return false; 
	}
}
