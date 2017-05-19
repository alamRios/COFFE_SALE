package com.coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteDelSistemaDTO extends ReporteFalloDTO {
	public String pantallaDeError; // En donde fue el fallo
	
	public ReporteDelSistemaDTO() {
		this(new Date(), "", "", "", "");
	}
	public ReporteDelSistemaDTO(Date fechaCreacion, String folioReporte,
			String observaciones, String descripcionFallo, String pantallaDeError) {
		super(fechaCreacion, folioReporte, observaciones, descripcionFallo);
		this.pantallaDeError = pantallaDeError; 
	}

	public ReporteDelSistemaDTO(ReporteDelSistemaDTO reporteSistema) {
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
			if(obj instanceof ReporteDelSistemaDTO){
				ReporteDelSistemaDTO reporte = (ReporteDelSistemaDTO) obj; 
				if(reporte.pantallaDeError.equals(this.pantallaDeError))
					return true; 
			}
		}return false; 
	}
}
