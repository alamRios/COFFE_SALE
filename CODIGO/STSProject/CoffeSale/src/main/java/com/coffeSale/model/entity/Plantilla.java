package com.coffeSale.model.entity;

import java.io.Serializable; 

public class Plantilla implements Serializable{
	private static final long serialVersionUID = 5935953117074129769L;
	
	private int id; 
	private int numeroEmpleados;
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
