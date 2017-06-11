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
@Table(name="PUESTO")
public class PuestoEntity implements Serializable {
	private static final long serialVersionUID = 2437648483869269709L;
	
	@Id
	@Column(name="PUESTO_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="puesto_puesto_id_seq", name="puesto_puesto_id_seq")
	@GeneratedValue(generator="puesto_puesto_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="PUESTO_NOMBRE")
	private String nombre; 
	
	public PuestoEntity(){
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
