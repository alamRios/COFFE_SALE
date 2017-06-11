package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria{	
	private List<Plantilla> plantillas;
	private List<Gaveta> gavetas; 
	private List<Venta> ventas; 
	private List<Habitacion> habitaciones; 
	private Inventario inventario; 
	private String nombre; 
	private String linea; 
	private String identificador;
	private boolean aceptaMembresias;
	private String email; 
	private String direccion;
	
	public Cafeteria(){
		this(
			new ArrayList<Plantilla>(),
			new ArrayList<Gaveta>(),
			new ArrayList<Venta>(),
			new ArrayList<Habitacion>(),
			new Inventario(), 
			"", "", "",
			true,
			"",
			""
		);
	}
	public Cafeteria(List<Plantilla> plantillas, List<Gaveta> gavetas,
					 List<Venta> ventas, List<Habitacion> habitaciones,
					 Inventario inventario, String nombre,
					 String linea, String identificador, boolean aceptaMembresias,
					 String email, String direccion) {
		super();
		this.plantillas = plantillas;
		this.gavetas = gavetas;
		this.ventas = ventas;
		this.habitaciones = habitaciones;
		this.inventario = inventario;
		this.nombre = nombre;
		this.linea = linea;
		this.identificador = identificador;
		this.aceptaMembresias = aceptaMembresias; 
		this.email = email;
		this.direccion = direccion;
	}
	public Cafeteria(Cafeteria cafeteria){
		this(
			cafeteria.plantillas,
			cafeteria.gavetas, 
			cafeteria.ventas, 
			cafeteria.habitaciones, 
			cafeteria.inventario, 
			cafeteria.nombre,
			cafeteria.linea, 
			cafeteria.identificador,
			cafeteria.aceptaMembresias,
			cafeteria.email,
			cafeteria.direccion
		);
	}

	public List<Plantilla> getPlantillas() {

		return plantillas;
	}

	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}

	public List<Gaveta> getGavetas() {
		return gavetas;
	}

	public void setGavetas(List<Gaveta> gavetas) {
		this.gavetas = gavetas;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public boolean isAceptaMembresias() {
		return aceptaMembresias;
	}

	public void setAceptaMembresias(boolean aceptaMembresias) {
		this.aceptaMembresias = aceptaMembresias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cafeteria cafeteria = (Cafeteria) o;

		if (aceptaMembresias != cafeteria.aceptaMembresias) return false;
		if (plantillas != null ? !plantillas.equals(cafeteria.plantillas) : cafeteria.plantillas != null) return false;
		if (gavetas != null ? !gavetas.equals(cafeteria.gavetas) : cafeteria.gavetas != null) return false;
		if (ventas != null ? !ventas.equals(cafeteria.ventas) : cafeteria.ventas != null) return false;
		if (habitaciones != null ? !habitaciones.equals(cafeteria.habitaciones) : cafeteria.habitaciones != null)
			return false;
		if (inventario != null ? !inventario.equals(cafeteria.inventario) : cafeteria.inventario != null) return false;
		if (nombre != null ? !nombre.equals(cafeteria.nombre) : cafeteria.nombre != null) return false;
		if (linea != null ? !linea.equals(cafeteria.linea) : cafeteria.linea != null) return false;
		if (identificador != null ? !identificador.equals(cafeteria.identificador) : cafeteria.identificador != null)
			return false;
		if (email != null ? !email.equals(cafeteria.email) : cafeteria.email != null) return false;
		return direccion != null ? direccion.equals(cafeteria.direccion) : cafeteria.direccion == null;
	}
}
