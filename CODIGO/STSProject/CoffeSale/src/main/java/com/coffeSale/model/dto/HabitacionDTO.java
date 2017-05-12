package com.coffeSale.model.dto;

public class HabitacionDTO {
	private String uso;
	private String descripcion;

	private double ancho; 
	private double largo;
	
	public HabitacionDTO(){
		this("", "", 0.0, 0.0);
	}
	public HabitacionDTO(String uso, String descripcion, double ancho, double largo) {
		super();
		this.uso = uso;
		this.descripcion = descripcion; 
		this.ancho = ancho;
		this.largo = largo;
	}
	public HabitacionDTO(HabitacionDTO habitacion){
		this(
			habitacion.uso,
			habitacion.descripcion,
			habitacion.ancho,
			habitacion.largo
		);
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}
	@Override
	public String toString() {
		return "HabitacionDTO{uso=" + uso + ", descripcion=" + descripcion
				+ ", ancho=" + ancho + ", largo=" + largo + "}";
	}
	
	
}
