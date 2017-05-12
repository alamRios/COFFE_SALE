package com.coffeSale.model.entity;

import java.io.Serializable;

public class Permiso implements Serializable{
	private static final long serialVersionUID = -8634349219169506107L;
	
	private int id; 
	private String descripcion; 
	private int empleado; 
	
	public Permiso(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Permiso{id=" + id + ", descripcion=" + descripcion
				+ ", empleado=" + empleado + "}";
	}
}
