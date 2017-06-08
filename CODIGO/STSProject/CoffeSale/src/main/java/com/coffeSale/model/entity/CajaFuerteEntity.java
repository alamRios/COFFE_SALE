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
@Table(name="CAJA_FUERTE")
public class CajaFuerteEntity implements Serializable{
	private static final long serialVersionUID = 3788025186393023336L;
	
	@Id
	@Column(name="CAJA_FUERTE_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="caja_fuerte_caja_fuerte_id_seq", name="caja_fuerte_caja_fuerte_id_seq")
	@GeneratedValue(generator="caja_fuerte_caja_fuerte_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="CAJA_FUERTE_CAFETERIA")
	private int cafeteriaId;
	
	@Column(name="CAJA_FUERTE_MONTO_TOTAL")
	private float montoTotal; 
	
	@Column(name="CAJA_FUERTE_CAPACIDAD")
	private float capacidad; 
	
	public CajaFuerteEntity(){
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

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "CajaFuerte{id=" + id + ", cafeteriaId=" + cafeteriaId
				+ ", montoTotal=" + montoTotal + ", capacidad=" + capacidad
				+ "}";
	}
}
