package com.coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import com.coffeSale.model.dto.Venta;

public class ReporteDeVentasDelAnno extends ReporteDeVentas {
	private String anno;
	
	public ReporteDeVentasDelAnno(){
		this(new Date(), "", "", new ArrayList<Venta>(), 0.0, "");
	}
	public ReporteDeVentasDelAnno(Date fechaCreacion, String folioReporte,
			String observaciones, ArrayList<Venta> ventasEnReporte, 
			double montoTotal,String anno) {
		super(fechaCreacion,folioReporte,observaciones,
				ventasEnReporte,montoTotal);
		this.anno = anno;
	} 
	public ReporteDeVentasDelAnno(ReporteDeVentasDelAnno rdvda){
		this(
			rdvda.fechaCreacion, 
			rdvda.folioReporte,
			rdvda.observaciones,
			rdvda.ventasEnReporte,
			rdvda.montoTotal, 
			rdvda.anno
		);
	}
	
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	@Override
	public String toString() {
		return "ReporteDeVentasDelAnno [anno=" + anno + ", ventasEnReporte="
				+ ventasEnReporte + ", montoTotal=" + montoTotal
				+ ", fechaCreacion=" + fechaCreacion + ", folioReporte="
				+ folioReporte + ", observaciones=" + observaciones + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof ReporteDeVentasDelAnno){
				ReporteDeVentasDelAnno reporte = (ReporteDeVentasDelAnno) obj; 
				if(reporte.anno.equals(this.anno))
					return true; 
			}
		}return false;
	}
}
