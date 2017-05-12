package com.coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

public class ReporteFallo implements Serializable{
	private static final long serialVersionUID = 4397978275390862241L;
	
	private int id; 
	private int cafeteria; 
	private String descripcion; 
	private int empleado; 
	private Date fechaAlta; 
	private Date fechaAtencion; 
	private boolean solucionado; 
	
	public ReporteFallo(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(int cafeteria) {
		this.cafeteria = cafeteria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public boolean isSolucionado() {
		return solucionado;
	}

	public void setSolucionado(boolean solucionado) {
		this.solucionado = solucionado;
	}

	@Override
	public String toString() {
		return "ReporteFallo{id=" + id + ", cafeteria=" + cafeteria
				+ ", descripcion=" + descripcion + ", empleado=" + empleado
				+ ", fechaAlta=" + fechaAlta + ", fechaAtencion="
				+ fechaAtencion + ", solucionado=" + solucionado + "}";
	}
}
