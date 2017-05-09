package coffeSale.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Venta implements Serializable{
	private static final long serialVersionUID = 7145142779203406704L;
	
	private int id; 
	private int promocionId; 
	private int cafeteriaId; 
	private int empleadoId; 
	private int cliente; 
	private float importe; 
	private Date inicio; 
	private Date fin; 
	
	public Venta(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPromocionId() {
		return promocionId;
	}

	public void setPromocionId(int promocionId) {
		this.promocionId = promocionId;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Venta{id=" + id + ", promocionId=" + promocionId
				+ ", cafeteriaId=" + cafeteriaId + ", empleadoId=" + empleadoId
				+ ", cliente=" + cliente + ", importe=" + importe + ", inicio="
				+ inicio + ", fin=" + fin + "}";
	}
}
