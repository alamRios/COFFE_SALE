package com.coffeSale.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLANTILLA")
public class Plantilla implements Serializable{
	private static final long serialVersionUID = 5935953117074129769L;
	
	@Id
	@Column(name="PLANTILLA_ID")
	private int id; 
	
	@Column(name="PLANTILLA_NoEMPLEADOS")
	private int numeroEmpleados;
	
	@Column(name="PLANTILLA_CAFETERIA")
	private int cafeteriaId;
	
	public Plantilla(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	@Override
	public String toString() {
		return "Plantilla{id=" + id + ", numeroEmpleados=" + numeroEmpleados
				+ ", cafeteriaId=" + cafeteriaId + "}";
	}
}
