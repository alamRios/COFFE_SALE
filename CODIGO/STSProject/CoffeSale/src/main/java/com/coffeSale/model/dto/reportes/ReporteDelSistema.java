package com.coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteDelSistema extends ReporteFallo {
	public String pantallaDeError; // En donde fue el fallo
	
	public ReporteDelSistema() {
		this(new Date(), "", "", "", "");
	}
	public ReporteDelSistema(Date fechaCreacion, String folioReporte,
			String observaciones, String descripcionFallo, String pantallaDeError) {
		super(fechaCreacion, folioReporte, observaciones, descripcionFallo);
		this.pantallaDeError = pantallaDeError; 
	}

	public ReporteDelSistema(ReporteDelSistema reporteSistema) {
		this(
			reporteSistema.fechaCreacion,
			reporteSistema.folioReporte, 
			reporteSistema.observaciones, 
			reporteSistema.descripcionFallo,
			reporteSistema.pantallaDeError
		);
	}
	
	public String getPantallaDeError() {
		return pantallaDeError;
	}
	public void setPantallaDeError(String pantallaDeError) {
		this.pantallaDeError = pantallaDeError;
	}
	
	@Override
	public String toString() {
		return "ReporteDelSistema [pantallaDeError=" + pantallaDeError
				+ ", descripcionFallo=" + descripcionFallo + ", fechaCreacion="
				+ fechaCreacion + ", folioReporte=" + folioReporte
				+ ", observaciones=" + observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteDelSistema){
				ReporteDelSistema reporte = (ReporteDelSistema) obj; 
				if(reporte.pantallaDeError.equals(this.pantallaDeError))
					return true; 
			}
		}return false; 
	}
}
