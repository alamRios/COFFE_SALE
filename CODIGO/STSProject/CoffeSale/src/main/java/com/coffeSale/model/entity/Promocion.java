package com.coffeSale.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROMOCION")
public class Promocion implements Serializable{
	private static final long serialVersionUID = -2182210060667261878L;
	
	@Id
	@Column(name="PRODUCTO_ID")
	private int id; 
	
	@Column(name="PRODUCTO_DESCRIPCION")
	private String descripcion; 
	
	@Column(name="PRODUCTO_PORCENTAJE")
	private float procentaje; 
	
	@Column(name="PRODUCTO_CODIGO")
	private String codigo; 
	
	public Promocion(){
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

	public float getProcentaje() {
		return procentaje;
	}

	public void setProcentaje(float procentaje) {
		this.procentaje = procentaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Promocion{id=" + id + ", descripcion=" + descripcion
				+ ", procentaje=" + procentaje + ", codigo=" + codigo + "}";
	}
}
