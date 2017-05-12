package com.coffeSale.model.entity;

import java.io.Serializable;

public class Puesto implements Serializable {
	private static final long serialVersionUID = 2437648483869269709L;
	
	private int id; 
	private String nombre; 
	
	public Puesto(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Puesto{id=" + id + ", nombre=" + nombre + "}";
	}
}
