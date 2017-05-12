package com.coffeSale.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 3661590877343683715L;
	
	private int id; 
	private String nombre; 
	private String appat; 
	private String apmat; 
	private String email; 
	private int cafeteriaId; 
	private Date fechaAlata; 
	private boolean activo; 
	
	public Cliente(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public Date getFechaAlata() {
		return fechaAlata;
	}

	public void setFechaAlata(Date fechaAlata) {
		this.fechaAlata = fechaAlata;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente{id=" + id + ", nombre=" + nombre + ", appat=" + appat
				+ ", apmat=" + apmat + ", email=" + email + ", cafeteriaId="
				+ cafeteriaId + ", fechaAlata=" + fechaAlata + ", activo="
				+ activo + "}";
	}
}
