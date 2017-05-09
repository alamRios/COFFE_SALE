package coffeSale.model.dto.reportes;

import java.util.ArrayList;
import java.util.Date;

import coffeSale.model.dto.VentaDTO;

public class ReporteDeVentasDelAnnoDTO extends ReporteDeVentasDTO {
	private String anno;
	
	public ReporteDeVentasDelAnnoDTO(){
		this(new Date(), "", "", new ArrayList<>(), 0.0, "");
	}
	public ReporteDeVentasDelAnnoDTO(Date fechaCreacion, String folioReporte,
			String observaciones, ArrayList<VentaDTO> ventasEnReporte, 
			double montoTotal,String anno) {
		super(fechaCreacion,folioReporte,observaciones,
				ventasEnReporte,montoTotal);
		this.anno = anno;
	} 
	public ReporteDeVentasDelAnnoDTO(ReporteDeVentasDelAnnoDTO rdvda){
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
}
