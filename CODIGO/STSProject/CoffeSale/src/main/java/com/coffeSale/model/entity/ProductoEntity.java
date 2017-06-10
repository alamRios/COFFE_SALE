package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.coffeSale.model.dto.Producto;

@Entity
@Table(name="PRODUCTO")
public class ProductoEntity implements Serializable{
	private static final long serialVersionUID = -8738715846179084757L;
	
	@Id
	@Column(name="PRODUCTO_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="producto_producto_id_seq", name="producto_producto_id_seq")
	@GeneratedValue(generator="producto_producto_id_seq", strategy=GenerationType.SEQUENCE)
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

	public Producto getProducto() {
		return new Producto(this.nombre, String.valueOf(this.id), this.costo);
	}
}
