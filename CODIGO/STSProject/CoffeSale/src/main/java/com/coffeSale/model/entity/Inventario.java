package com.coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INVENTARIO")
public class Inventario implements Serializable{
	private static final long serialVersionUID = 2550256351903577355L;
	
	@Id
	@Column(name="INVENTARIO_ID")
	private int id; 
	
	@Column(name="INVENTARIO_CAFETERIA")
	private int cafeteriaId; 
	
	@Column(name="INVENTARIO_PRODUCTO")
	private int producto; 
	
	@Column(name="INVENTARIO_CANTIDAD")
	private int cantidad; 
	
	@Column(name="INVENTARIO_ULTIMA_ACTUALIZACION")
	private Date ultimaActualizacion; 
	
	public Inventario(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Override
	public String toString() {
		return "Inventario{id=" + id + ", cafeteriaId=" + cafeteriaId
				+ ", producto=" + producto + ", cantidad=" + cantidad
				+ ", ultimaActualizacion=" + ultimaActualizacion + "}";
	}
}
