package com.coffeSale.model.dto;

import java.util.ArrayList;

public class Cafeteria{	
	private Plantilla plantilla; 
	private ArrayList<Gaveta> gavetas; 
	private ArrayList<Venta> ventas; 
	private ArrayList<Habitacion> habitaciones; 
	private Inventario inventario; 
	private CajaFuerte cajaFuerte; 
	private String nombre; 
	private String linea; 
	private String identificador;
	
	public Cafeteria(){
		this(
			new Plantilla(), 
			new ArrayList<Gaveta>(),
			new ArrayList<Venta>(),
			new ArrayList<Habitacion>(),
			new Inventario(), 
			new CajaFuerte(),
			"", "", ""
		);
	}
	public Cafeteria(Plantilla plantilla, ArrayList<Gaveta> gavetas,
			ArrayList<Venta> ventas, ArrayList<Habitacion> habitaciones,
			Inventario inventario, CajaFuerte cajaFuerte, String nombre,
			String linea, String identificador) {
		super();
		this.plantilla = plantilla;
		this.gavetas = gavetas;
		this.ventas = ventas;
		this.habitaciones = habitaciones;
		this.inventario = inventario;
		this.cajaFuerte = cajaFuerte;
		this.nombre = nombre;
		this.linea = linea;
		this.identificador = identificador;
	}
	public Cafeteria(Cafeteria cafeteria){
		this(
			cafeteria.plantilla, 
			cafeteria.gavetas, 
			cafeteria.ventas, 
			cafeteria.habitaciones, 
			cafeteria.inventario, 
			cafeteria.cajaFuerte, 
			cafeteria.nombre, 
			cafeteria.linea, 
			cafeteria.identificador
		);
	}

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	public ArrayList<Gaveta> getGavetas() {
		return gavetas;
	}

	public void setGavetas(ArrayList<Gaveta> gavetas) {
		this.gavetas = gavetas;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public CajaFuerte getCajaFuerte() {
		return cajaFuerte;
	}

	public void setCajaFuerte(CajaFuerte cajaFuerte) {
		this.cajaFuerte = cajaFuerte;
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

	@Override
	public String toString() {
		return "Cafeteria [plantilla=" + plantilla + ", gavetas=" + gavetas
				+ ", ventas=" + ventas + ", habitaciones=" + habitaciones
				+ ", inventario=" + inventario + ", cajaFuerte=" + cajaFuerte
				+ ", nombre=" + nombre + ", linea=" + linea
				+ ", identificador=" + identificador + "]";
	} 	
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Cafeteria){
				Cafeteria cafeteria = (Cafeteria) obj; 
				if(cafeteria.cajaFuerte.equals(this.cajaFuerte)
					&& cafeteria.identificador.equals(this.identificador)
					&& cafeteria.inventario.equals(this.inventario)
					&& cafeteria.linea.equals(this.linea)
					&& cafeteria.nombre.equals(this.nombre)
					&& cafeteria.plantilla.equals(this.plantilla)){
					for(Gaveta gaveta : cafeteria.gavetas)
						if(!this.gavetas.contains(gaveta))
							return false;
					for(Habitacion habitacion : cafeteria.habitaciones)
						if(!this.habitaciones.contains(habitacion))
							return false; 
					for(Venta venta : cafeteria.ventas)
						if(!this.ventas.contains(venta))
							return false;					
					return true;
				}
			}
		}
		return false; 
	}
	
	
}
