package com.coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteDeMantenimiento extends ReporteFallo {
	private String areaDeMantenimiento; 
	private String especificacionTecnica;
	
	public ReporteDeMantenimiento(){
		this(new Date(), "", "", "", "", "");
	}
	public ReporteDeMantenimiento(Date fechaCreacion, String folioReporte, 
			String observaciones, String descripcionFallo, 
			String areaDeMantenimiento, String especificacionTecnica) {
		super(fechaCreacion, folioReporte, observaciones, descripcionFallo);
		this.areaDeMantenimiento = areaDeMantenimiento;
		this.especificacionTecnica = especificacionTecnica;
	} 
	public ReporteDeMantenimiento(ReporteDeMantenimiento rdm){
		this(rdm.fechaCreacion, rdm.folioReporte,rdm.observaciones,
				rdm.descripcionFallo, rdm.areaDeMantenimiento, 
				rdm.especificacionTecnica);
	}
	
	public String getAreaDeMantenimiento() {
		return areaDeMantenimiento;
	}
	public void setAreaDeMantenimiento(String areaDeMantenimiento) {
		this.areaDeMantenimiento = areaDeMantenimiento;
	}
	public String getEspecificacionTecnica() {
		return especificacionTecnica;
	}
	public void setEspecificacionTecnica(String especificacionTecnica) {
		this.especificacionTecnica = especificacionTecnica;
	}
	
	@Override
	public String toString() {
		return "ReporteDeMantenimiento [areaDeMantenimiento="
				+ areaDeMantenimiento + ", especificacionTecnica="
				+ especificacionTecnica + ", descripcionFallo="
				+ descripcionFallo + ", fechaCreacion=" + fechaCreacion
				+ ", folioReporte=" + folioReporte + ", observaciones="
				+ observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteDeMantenimiento){
				ReporteDeMantenimiento reporte = (ReporteDeMantenimiento) obj; 
				if(reporte.areaDeMantenimiento.equals(this.areaDeMantenimiento)
					&& reporte.especificacionTecnica.equals(this.especificacionTecnica))
					return true; 
			}
		}return false; 
	}
}
