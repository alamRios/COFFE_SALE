package com.coffeSale.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable{
	private static final long serialVersionUID = -2055483235949311482L;
	
	private int id; 
	private int puestoId; 
	private int horarioId; 
	private String correo; 
	private String nombre; 
	private String appat; 
	private String apmat; 
	private Date contratacion;
	private float salario; 
	
	public Empleado(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuestoId() {
		return puestoId;
	}

	public void setPuestoId(int puestoId) {
		this.puestoId = puestoId;
	}

	public int getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppat() {
		return appat;
	}

	public void setAppat(String appat) {
		this.appat = appat;
	}

	public String getApmat() {
		return apmat;
	}

	public void setApmat(String apmat) {
		this.apmat = apmat;
	}

	public Date getContratacion() {
		return contratacion;
	}

	public void setContratacion(Date contratacion) {
		this.contratacion = contratacion;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado{id=" + id + ", puestoId=" + puestoId
				+ ", horarioId=" + horarioId + ", correo=" + correo
				+ ", nombre=" + nombre + ", appat=" + appat + ", apmat="
				+ apmat + ", contratacion=" + contratacion + ", salario="
				+ salario + "}";
	}
	
	
}
