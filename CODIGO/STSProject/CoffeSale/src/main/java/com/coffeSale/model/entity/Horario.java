package com.coffeSale.model.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HORARIO")
public class Horario implements Serializable{
	private static final long serialVersionUID = -8177814363886103358L;
	
	@Id
	@Column(name="HORARIO_ID")
	private int id;
	
	@Column(name="HORARIO_DESCRIPCION")
	private String descripcion; 
	
	@Column(name="HORARIO_ENTRADA")
	private Time entrada; 
	
	@Column(name="HORARIO_SALIDA")
	private Time salida; 
	
	@Column(name="HORARIO_ENTRADA_COMIDA")
	private Time entradaComida; 
	
	@Column(name="HORARIO_SALIDA_COMIDA")
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
