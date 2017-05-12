package com.coffeSale.model.entity;

import java.io.Serializable;
import java.sql.Time;

public class Horario implements Serializable{
	private static final long serialVersionUID = -8177814363886103358L;
	
	private int id;
	private String descripcion; 
	private Time entrada; 
	private Time salida; 
	private Time entradaComida; 
	private Time salidaComida; 
	
	public Horario(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Time getEntrada() {
		return entrada;
	}

	public void setEntrada(Time entrada) {
		this.entrada = entrada;
	}

	public Time getSalida() {
		return salida;
	}

	public void setSalida(Time salida) {
		this.salida = salida;
	}

	public Time getEntradaComida() {
		return entradaComida;
	}

	public void setEntradaComida(Time entradaComida) {
		this.entradaComida = entradaComida;
	}

	public Time getSalidaComida() {
		return salidaComida;
	}

	public void setSalidaComida(Time salidaComida) {
		this.salidaComida = salidaComida;
	}

	@Override
	public String toString() {
		return "Horario{id=" + id + ", descripcion=" + descripcion
				+ ", entrada=" + entrada + ", salida=" + salida
				+ ", entradaComida=" + entradaComida + ", salidaComida="
				+ salidaComida + "}";
	}
}
