package coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

public class Inventario implements Serializable{
	private static final long serialVersionUID = 2550256351903577355L;
	
	private int id; 
	private int cafeteriaId; 
	private int producto; 
	private int cantidad; 
	private Date ultimaActualizacion; 
	
	public Inventario(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Override
	public String toString() {
		return "Inventario{id=" + id + ", cafeteriaId=" + cafeteriaId
				+ ", producto=" + producto + ", cantidad=" + cantidad
				+ ", ultimaActualizacion=" + ultimaActualizacion + "}";
	}
}
