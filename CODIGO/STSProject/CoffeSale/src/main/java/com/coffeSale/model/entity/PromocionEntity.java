package com.coffeSale.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PROMOCION")
public class PromocionEntity implements Serializable{
	private static final long serialVersionUID = -2182210060667261878L;
	
	@Id
	@Column(name="PROMOCION_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="promocion_promocion_id_seq", name="promocion_promocion_id_seq")
	@GeneratedValue(generator="promocion_promocion_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="PROMOCION_DESCRIPCION")
	private String descripcion; 
	
	@Column(name="PROMOCION_PORCENTAJE")
	private float procentaje; 
	
	@Column(name="PROMOCION_CODIGO")
	private String codigo; 
	
	public PromocionEntity(){
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
