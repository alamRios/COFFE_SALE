package com.coffeSale.model.dto;

import java.util.Date;

public class GavetaDTO {
	private double fondo; 
	private Date ultimaApertura;
	
	public GavetaDTO(){
		this(0.0, new Date());
	}
	public GavetaDTO(double fondo, Date ultimaApertura) {
		super();
		this.fondo = fondo;
		this.ultimaApertura = ultimaApertura;
	}
	public GavetaDTO(GavetaDTO gaveta){
		this(
			gaveta.fondo,
			gaveta.ultimaApertura
		);
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public Date getUltimaApertura() {
		return ultimaApertura;
	}

	public void setUltimaApertura(Date ultimaApertura) {
		this.ultimaApertura = ultimaApertura;
	}

	@Override
	public String toString() {
		return "Gaveta [fondo=" + fondo + ", ultimaApertura=" + ultimaApertura
				+ "]";
	}
}
