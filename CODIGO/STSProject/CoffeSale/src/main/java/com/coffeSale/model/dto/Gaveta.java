package com.coffeSale.model.dto;


public class Gaveta {
	private double fondo; 
	private double capacidad; 
	
	public Gaveta(){
		this(0.0, 0.0);
	}
	public Gaveta(double fondo, double capacidad) {
		super();
		this.fondo = fondo;
		this.capacidad = capacidad; 
	}
	public Gaveta(Gaveta gaveta){
		this(
			gaveta.fondo,
			gaveta.capacidad
		);
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return "Gaveta{fondo=" + fondo + ", capacidad=" + capacidad + "}";
	}
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Gaveta){
				Gaveta gaveta = (Gaveta) obj; 
				if(gaveta.fondo == this.fondo
					&& gaveta.capacidad == capacidad)
					return true; 
			}
		}
		return false; 
	}
}
