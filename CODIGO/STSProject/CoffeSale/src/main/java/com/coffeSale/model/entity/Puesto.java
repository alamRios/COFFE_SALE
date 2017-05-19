package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PUESTO")
public class Puesto implements Serializable {
	private static final long serialVersionUID = 2437648483869269709L;
	
	@Id
	@Column(name="PUESTO_ID")
	private int id; 
	
	@Column(name="PUESTO_NOMBRE")
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
