package com.coffeSale.model.dto;

public class Producto {
	private String nombre; 
	private String identificador; 
	private double costo;
	private int codigoLinea;
	
	public Producto(){
		this("", "", 0.0,0);
	}
	public Producto(String nombre, String identificador, 
			double costo, int codigoLinea) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.costo = costo;
		this.codigoLinea = codigoLinea; 
	}
	public Producto(Producto producto){
		this(
			producto.nombre,
			producto.identificador,
			producto.costo,
			producto.codigoLinea
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
	

	public int getCodigoLinea() {
		return codigoLinea;
	}
	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
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
