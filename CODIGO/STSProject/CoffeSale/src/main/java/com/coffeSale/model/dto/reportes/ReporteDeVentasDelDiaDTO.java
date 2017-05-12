package com.coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import com.coffeSale.model.dto.VentaDTO;

public class ReporteDeVentasDelDiaDTO extends ReporteDeVentasDTO{
	private Date dia;

	public ReporteDeVentasDelDiaDTO(){
		this(
			new Date(), "", "", new ArrayList<VentaDTO>(), 0.0, new Date()
		);
	}
	public ReporteDeVentasDelDiaDTO(Date fechaCreacion, String folioReporte,
			String observaciones, ArrayList<VentaDTO> ventasEnReporte, 
			double montoTotal, Date dia) {
		super(fechaCreacion, folioReporte, observaciones, 
				ventasEnReporte, montoTotal);
		this.dia = dia;
	}
	public ReporteDeVentasDelDiaDTO(ReporteDeVentasDelDiaDTO rdvd){
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
}
