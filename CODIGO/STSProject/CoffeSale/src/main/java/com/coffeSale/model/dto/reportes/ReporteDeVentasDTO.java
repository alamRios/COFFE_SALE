package com.coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import com.coffeSale.model.dto.VentaDTO;

public class ReporteDeVentasDTO extends ReporteDTO{
	protected ArrayList<VentaDTO> ventasEnReporte;
	protected double montoTotal; 
	
	public ReporteDeVentasDTO(){
		this(new Date(), "", "",new ArrayList<VentaDTO>(), 0.0); 
	}
	public ReporteDeVentasDTO(Date fechaCreacion, String folioReporte, 
			String observaciones,ArrayList<VentaDTO> ventasEnReporte, 
			double montoTotal) {
		super(fechaCreacion, folioReporte, observaciones);
		this.ventasEnReporte = ventasEnReporte;
		this.montoTotal = montoTotal; 
	}
	public ReporteDeVentasDTO(ReporteDeVentasDTO reporteDeVentas){
		this(
			reporteDeVentas.fechaCreacion, 
			reporteDeVentas.folioReporte, 
			reporteDeVentas.observaciones,
			reporteDeVentas.ventasEnReporte, 
			reporteDeVentas.montoTotal
		);
	}

	public ArrayList<VentaDTO> getVentasEnReporte() {
		return ventasEnReporte;
	}

	public void setVentasEnReporte(ArrayList<VentaDTO> ventasEnReporte) {
		this.ventasEnReporte = ventasEnReporte;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	@Override
	public String toString() {
		return "ReporteDeVentas [ventasEnReporte=" + ventasEnReporte
				+ ", montoTotal=" + montoTotal + ", fechaCreacion="
				+ fechaCreacion + ", folioReporte=" + folioReporte
				+ ", observaciones=" + observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteDeVentasDTO){
				ReporteDeVentasDTO reporte = (ReporteDeVentasDTO) obj; 
				if(reporte.montoTotal == this.montoTotal){
					for(VentaDTO venta : reporte.ventasEnReporte){
						if(!this.ventasEnReporte.contains(venta)){
							return false;
						}
						return true; 
					}
				}
			}
		}return false; 
	}
}
