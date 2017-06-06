package com.coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import com.coffeSale.model.dto.Venta;

public class ReporteDeVentas extends Reporte{
	protected ArrayList<Venta> ventasEnReporte;
	protected double montoTotal; 
	
	public ReporteDeVentas(){
		this(new Date(), "", "",new ArrayList<Venta>(), 0.0); 
	}
	public ReporteDeVentas(Date fechaCreacion, String folioReporte, 
			String observaciones,ArrayList<Venta> ventasEnReporte, 
			double montoTotal) {
		super(fechaCreacion, folioReporte, observaciones);
		this.ventasEnReporte = ventasEnReporte;
		this.montoTotal = montoTotal; 
	}
	public ReporteDeVentas(ReporteDeVentas reporteDeVentas){
		this(
			reporteDeVentas.fechaCreacion, 
			reporteDeVentas.folioReporte, 
			reporteDeVentas.observaciones,
			reporteDeVentas.ventasEnReporte, 
			reporteDeVentas.montoTotal
		);
	}

	public ArrayList<Venta> getVentasEnReporte() {
		return ventasEnReporte;
	}

	public void setVentasEnReporte(ArrayList<Venta> ventasEnReporte) {
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
			if(obj instanceof ReporteDeVentas){
				ReporteDeVentas reporte = (ReporteDeVentas) obj; 
				if(reporte.montoTotal == this.montoTotal){
					for(Venta venta : reporte.ventasEnReporte){
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
