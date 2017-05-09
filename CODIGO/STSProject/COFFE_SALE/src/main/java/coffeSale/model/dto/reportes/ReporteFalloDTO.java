package coffeSale.model.dto.reportes;

import java.util.Date;

public class ReporteFalloDTO extends ReporteDTO {
	protected String descripcionFallo;
	
	public ReporteFalloDTO(){
		this(
			new Date(), 
			"", "", ""
		);
	}
	public ReporteFalloDTO(Date fechaCreacion, String folioReporte, String observaciones, String descripcionFallo) {
		super(fechaCreacion, folioReporte, observaciones);
		this.descripcionFallo = descripcionFallo;
	}
	public ReporteFalloDTO(ReporteFalloDTO reporteFallo){
		this(
			reporteFallo.fechaCreacion, 
			reporteFallo.folioReporte, 
			reporteFallo.observaciones, 
			reporteFallo.descripcionFallo
		);
	}

	public String getDescripcionFallo() {
		return descripcionFallo;
	}

	public void setDescripcionFallo(String descripcionFallo) {
		this.descripcionFallo = descripcionFallo;
	}
	
	@Override
	public String toString() {
		return "ReporteFallo [descripcionFallo=" + descripcionFallo
				+ ", fechaCreacion=" + fechaCreacion + ", folioReporte="
				+ folioReporte + ", observaciones=" + observaciones + "]";
	}
}
