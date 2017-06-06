package com.coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteFallo extends Reporte {
	protected String descripcionFallo;
	
	public ReporteFallo(){
		this(
			new Date(), 
			"", "", ""
		);
	}
	public ReporteFallo(Date fechaCreacion, String folioReporte, String observaciones, String descripcionFallo) {
		super(fechaCreacion, folioReporte, observaciones);
		this.descripcionFallo = descripcionFallo;
	}
	public ReporteFallo(ReporteFallo reporteFallo){
		this(
			reporteFallo.fechaCreacion, 
			reporteFallo.folioReporte, 
			reporteFallo.observaciones, 
			reporteFallo.descripcionFallo
		);
	}

	public String getDescripcionFallo() {
		return descripcionFallo;
	}

	public void setDescripcionFallo(String descripcionFallo) {
		this.descripcionFallo = descripcionFallo;
	}
	
	@Override
	public String toString() {
		return "ReporteFallo [descripcionFallo=" + descripcionFallo
				+ ", fechaCreacion=" + fechaCreacion + ", folioReporte="
				+ folioReporte + ", observaciones=" + observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteFallo){
				ReporteFallo reporte = (ReporteFallo) obj; 
				if(reporte.descripcionFallo.equals(this.descripcionFallo))
					return true; 
			}
		}return false;
	}
}
