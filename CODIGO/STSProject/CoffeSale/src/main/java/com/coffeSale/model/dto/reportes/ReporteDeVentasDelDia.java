package com.coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import com.coffeSale.model.dto.Venta;

public class ReporteDeVentasDelDia extends ReporteDeVentas{
	private Date dia;

	public ReporteDeVentasDelDia(){
		this(
			new Date(), "", "", new ArrayList<Venta>(), 0.0, new Date()
		);
	}
	public ReporteDeVentasDelDia(Date fechaCreacion, String folioReporte,
			String observaciones, ArrayList<Venta> ventasEnReporte, 
			double montoTotal, Date dia) {
		super(fechaCreacion, folioReporte, observaciones, 
				ventasEnReporte, montoTotal);
		this.dia = dia;
	}
	public ReporteDeVentasDelDia(ReporteDeVentasDelDia rdvd){
		this(
			rdvd.fechaCreacion, 
			rdvd.folioReporte,
			rdvd.observaciones, 
			rdvd.ventasEnReporte, 
			rdvd.montoTotal, 
			rdvd.dia
		);
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}
	@Override
	public String toString() {
		return "ReporteDeVentasDelDia [dia=" + dia + ", ventasEnReporte="
				+ ventasEnReporte + ", montoTotal=" + montoTotal
				+ ", fechaCreacion=" + fechaCreacion + ", folioReporte="
				+ folioReporte + ", observaciones=" + observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteDeVentasDelDia){
				ReporteDeVentasDelDia reporte = (ReporteDeVentasDelDia) obj; 
				if(reporte.dia.equals(this.dia))
					return true; 
			}
		}return false; 
	}
}
