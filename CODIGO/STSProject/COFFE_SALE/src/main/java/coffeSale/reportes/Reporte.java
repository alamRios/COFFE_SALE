package coffeSale.reportes;

import java.util.Date;

public class Reporte {
	protected Date fechaCreacion; 
	protected String folioReporte;
	protected String observaciones; 
	
	public Reporte(){
		this(new Date(), "", "");
	}
	public Reporte(Date fechaCreacion, String folioReporte, String observaciones) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.folioReporte = folioReporte;
		this.observaciones = observaciones; 
	}
	public Reporte(Reporte reporte){
		this(
			reporte.fechaCreacion, 
			reporte.folioReporte,
			reporte.observaciones
		);
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFolioReporte() {
		return folioReporte;
	}

	public void setFolioReporte(String folioReporte) {
		this.folioReporte = folioReporte;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "Reporte [fechaCreacion=" + fechaCreacion + ", folioReporte="
				+ folioReporte + ", observaciones=" + observaciones + "]";
	}	
}
