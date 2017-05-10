package coffeSale.model.entity;

import java.io.Serializable;

public class Gaveta implements Serializable{
	private static final long serialVersionUID = 8388174704300993987L;
	
	private int id; 
	private int cafeteriaId; 
	private float fondo; 
	private float capacidad; 
	
	public Gaveta(){
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

	public float getFondo() {
		return fondo;
	}

	public void setFondo(float fondo) {
		this.fondo = fondo;
	}

	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Gaveta{id=" + id + ", cafeteriaId=" + cafeteriaId + ", fondo="
				+ fondo + ", capacidad=" + capacidad + "}";
	}
}
