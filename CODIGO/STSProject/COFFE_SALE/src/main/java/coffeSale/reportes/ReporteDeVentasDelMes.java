package coffeSale.reportes;

import java.util.ArrayList;
import java.util.Date;

import coffeSale.entidades.Venta;

public class ReporteDeVentasDelMes extends ReporteDeVentas {
	private String mes; 
	private String anno;
	
	public ReporteDeVentasDelMes(){
		this(new Date(), "", "", new ArrayList<>(), 0.0, "", "");
	}
	public ReporteDeVentasDelMes(Date fechaCreacion, String folioReporte,
			String observaciones, ArrayList<Venta> ventasEnReporte, 
			double montoTotal, String mes, String anno) {
		super(fechaCreacion,folioReporte,observaciones,
				ventasEnReporte,montoTotal);
		this.mes = mes;
		this.anno = anno;
	}
	public ReporteDeVentasDelMes(ReporteDeVentasDelMes rdvdm){
		this(
			rdvdm.fechaCreacion, 
			rdvdm.folioReporte,
			rdvdm.observaciones,
			rdvdm.ventasEnReporte,
			rdvdm.montoTotal, 
			rdvdm.mes,
			rdvdm.anno
		);
	}
	
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	@Override
	public String toString() {
		return "ReporteDeVentasDelMes [mes=" + mes + ", anno=" + anno
				+ ", ventasEnReporte=" + ventasEnReporte + ", montoTotal="
				+ montoTotal + ", fechaCreacion=" + fechaCreacion
				+ ", folioReporte=" + folioReporte + ", observaciones="
				+ observaciones + "]";
	}
}
