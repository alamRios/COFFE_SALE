package coffeSale.reportes;

import java.util.Date;

public class ReporteFallo extends Reporte {
	private String descripcionFallo;
	
	public ReporteFallo(){
		this(
			new Date(), 
			"", "", ""
		);
	}
	public ReporteFallo(Date fechaCreacion, String folioReporte, String observaciones, String descripcionFallo) {
		super(fechaCreacion, folioReporte, observaciones);
		this.descripcionFallo = descripcionFallo;
	}
	public ReporteFallo(ReporteFallo reporteFallo){
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
	
}