package com.coffeSale.model.dto;

import java.util.Date;

public class CajaFuerte {
	private double fondo; 
	private double montoAlmacenado; 
	private Date fechaRevision;
	
	public CajaFuerte(){
		this(0.0, 0.0, new Date());
	}
	
	public CajaFuerte(double fondo, double montoAlmacenado, Date fechaRevision) {
		super();
		this.fondo = fondo;
		this.montoAlmacenado = montoAlmacenado;
		this.fechaRevision = fechaRevision;
	}
	
	public CajaFuerte(CajaFuerte cajaFuerte){
		this(
			cajaFuerte.fondo,
			cajaFuerte.montoAlmacenado,
			cajaFuerte.fechaRevision
		);
	}

	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public double getMontoAlmacenado() {
		return montoAlmacenado;
	}

	public void setMontoAlmacenado(double montoAlmacenado) {
		this.montoAlmacenado = montoAlmacenado;
	}

	public Date getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	@Override
	public String toString() {
		return "CajaFuerte [fondo=" + fondo + ", montoAlmacenado="
				+ montoAlmacenado + ", fechaRevision=" + fechaRevision + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof CajaFuerte){
				CajaFuerte cajaFuerte = (CajaFuerte) obj; 
				if(cajaFuerte.fechaRevision.equals(this.fechaRevision)
					&& cajaFuerte.fondo == this.fondo
					&& cajaFuerte.montoAlmacenado == this.montoAlmacenado)
					return true; 
			}
		}
		return false; 
	}
}
