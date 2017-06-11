package com.coffeSale.model.dto;

public class Producto {
	private String nombre; 
	private String identificador; 
	private double costo;
	
	public Producto(){
		this("", "", 0.0);
	}
	public Producto(String nombre, String identificador, double costo) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.costo = costo;
	}
	public Producto(Producto producto){
		this(
			producto.nombre,
			producto.identificador,
			producto.costo
		);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", identificador="
				+ identificador + ", costo=" + costo + "]";
	} 
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Producto){
				Producto producto = (Producto)obj; 
				if(producto.costo == this.costo
					&& producto.identificador.equals(this.identificador)
					&& producto.nombre.equals(this.nombre))
					return true; 
			}
		}return false; 
	}
}
