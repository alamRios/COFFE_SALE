package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coffeSale.model.dto.Gaveta;

@Entity
@Table(name="GAVETA")
public class GavetaEntity implements Serializable{
	private static final long serialVersionUID = 8388174704300993987L;
	
	@Id
	@Column(name="GAVETA_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="gaveta_gaveta_id_seq", name="gaveta_gaveta_id_seq")
	@GeneratedValue(generator="gaveta_gaveta_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="GAVETA_CAFETERIA")
	private int cafeteriaId; 
	
	@Column(name="GAVETA_FONDO")
	private float fondo; 
	
	@Column(name="GAVETA_CAPACIDAD")
	private float capacidad; 
	
	public GavetaEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public float getFondo() {
		return fondo;
	}

	public void setFondo(float fondo) {
		this.fondo = fondo;
	}

	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Gaveta{id=" + id + ", cafeteriaId=" + cafeteriaId + ", fondo="
				+ fondo + ", capacidad=" + capacidad + "}";
	}
	
	@Transient
	public Gaveta getGaveta() {
		return new Gaveta(
				this.fondo,
				this.capacidad
				);
	}
}
