package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Inventario {
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	private String codigoInventario;
	private List<Producto> productos;
	
	public Inventario(){
		this(new Date(), "", new ArrayList<Producto>());
	}
	public Inventario(Date fechaCreacion, String codigoInventario,
			List<Producto> productos) {
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
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
