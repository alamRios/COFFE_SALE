package com.coffeSale.model.dto;

public class ProductoDTO {
	private String nombre; 
	private String identificador; 
	private double costo; 
	private String proveedor;
	
	public ProductoDTO(){
		this("", "", 0.0, "");
	}
	public ProductoDTO(String nombre, String identificador, double costo,
			String proveedor) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.costo = costo;
		this.proveedor = proveedor;
	}
	public ProductoDTO(ProductoDTO producto){
		this(
			producto.nombre,
			producto.identificador,
			producto.costo,
			producto.proveedor
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

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", identificador="
				+ identificador + ", costo=" + costo + ", proveedor="
				+ proveedor + "]";
	} 
}
