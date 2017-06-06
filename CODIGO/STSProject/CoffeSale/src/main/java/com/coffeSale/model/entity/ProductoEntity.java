package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")
public class ProductoEntity implements Serializable{
	private static final long serialVersionUID = -8738715846179084757L;
	
	@Id
	@Column(name="PRODUCTO_ID")
	private int id; 

	@Column(name="PRODUCTO_NOMBRE")
	private String nombre; 
	
	@Column(name="PRODUTO_COSTO")
	private float costo; 
	
	public ProductoEntity(){
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Producto{id=" + id + ", nombre=" + nombre + ", costo=" + costo
				+ "}";
	}
}
