package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAREA")
public class Tarea implements Serializable{
	private static final long serialVersionUID = 291162223897654489L;
	
	@Id
	@Column(name="TAREA_ID")
	private int id; 
	
	@Column(name="TAREA_CAFETERIA")
	private int cafeteriaId; 
	
	@Column(name="TAREA_EMPLEADO")
	private int empleadoId; 
	
	@Column(name="TAREA_TITULO")
	private String titulo; 
	
	@Column(name="TAREA_DESCRIPCION")
	private String descripcion; 
	
	public Tarea(){
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

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tarea{id=" + id + ", cafeteriaId=" + cafeteriaId
				+ ", empleadoId=" + empleadoId + ", titulo=" + titulo
				+ ", descripcion=" + descripcion + "}";
	}
}
