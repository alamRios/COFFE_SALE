package com.coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

public class Plaza implements Serializable{
	private static final long serialVersionUID = 5974319249882759707L;
	
	private int id; 
	private int folio; 
	private int empleadoId; 
	private Date fechaAlta; 
	private Date fechaActualizacion; 
	private boolean activa; 
	private int plantillaId;
	
	public Plaza(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public int getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public int getPlantillaId() {
		return plantillaId;
	}
	public void setPlantillaId(int plantillaId) {
		this.plantillaId = plantillaId;
	}

	@Override
	public String toString() {
		return "Plaza{id=" + id + ", folio=" + folio + ", empleadoId="
				+ empleadoId + ", fechaAlta=" + fechaAlta
				+ ", fechaActualizacion=" + fechaActualizacion + ", activa="
				+ activa + ", plantillaId=" + plantillaId + "}";
	} 
}
