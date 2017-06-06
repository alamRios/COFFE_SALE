package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MARCA")
public class MarcaEntity implements Serializable{
	private static final long serialVersionUID = 4881519404543198107L;
	
	@Id
	@Column(name="MARCA_ID")
	private int id;
	
	@Column(name="MARCA_NOMBRE")
	private String nombre; 
	
	@Column(name="MARCA_RFC")
	private String rfc; 
	
	public MarcaEntity(){
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

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + ", rfc=" + rfc + "]";
	}
}
