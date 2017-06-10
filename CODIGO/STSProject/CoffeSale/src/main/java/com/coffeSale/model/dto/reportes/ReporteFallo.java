package com.coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteFallo extends Reporte {
	protected String descripcionFallo;
	protected int idEmpleadoGenera; 
	
	public ReporteFallo(){
		this(
			new Date(), 
			"", "", "",  0
		);
	}
	public ReporteFallo(Date fechaCreacion, String folioReporte, String observaciones,
		String descripcionFallo, int idEmpleadoGenera) {
		super(fechaCreacion, folioReporte, observaciones);
		this.descripcionFallo = descripcionFallo;
		this.idEmpleadoGenera = idEmpleadoGenera;
	}

	public ReporteFallo(ReporteFallo reporteFallo){
		this(
			reporteFallo.fechaCreacion,
			reporteFallo.folioReporte,
			reporteFallo.observaciones,
			reporteFallo.descripcionFallo,
				reporteFallo.idEmpleadoGenera

		);
	}

	public String getDescripcionFallo() {
		return descripcionFallo;
	}

	public void setDescripcionFallo(String descripcionFallo) {
		this.descripcionFallo = descripcionFallo;
	}

	public int getIdEmpleadoGenera() {
		return idEmpleadoGenera;
	}

	public void setIdEmpleadoGenera(int idEmpleadoGenera) {
		this.idEmpleadoGenera = idEmpleadoGenera;
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
