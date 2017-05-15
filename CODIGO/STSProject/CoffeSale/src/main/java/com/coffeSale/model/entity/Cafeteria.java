package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAFETERIA")
public class Cafeteria implements Serializable{
	private static final long serialVersionUID = -9019107116825708383L;
	
	@Id
	@Column(name="CAFETERIA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="CAFETERIA_NOMBRE")
	private String nombre; 
	
	@Column(name="CAFETERIA_ACEPTA_MEMBRESIAS")
	private boolean aceptaMembresias; 
	
	@Column(name="CAFETERIA_ESTADO")
	private String estado; 
	
	@Column(name="CAFETERIA_EMAIL")
	private String email; 
	
	@Column(name="CAFETERIA_DIRECCION")
	private int direccionId;
	
	@Column(name="CAFETERIA_MARCA")
	private int marcaId;
	
	public Cafeteria(){
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
	public boolean isAcepta_membresias() {
		return aceptaMembresias;
	}
	public void setAcepta_membresias(boolean acepta_membresias) {
		this.aceptaMembresias = acepta_membresias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}
	public int getMarcaId() {
		return marcaId;
	}
	public void setMarcaId(int marcaId) {
		this.marcaId = marcaId;
	}

	@Override
	public String toString() {
		return "Cafeteria{id=" + id + ", nombre=" + nombre
				+ ", aceptaMembresias=" + aceptaMembresias + ", estado="
				+ estado + ", email=" + email + ", direccionId=" + direccionId
				+ ", marcaId=" + marcaId + "}";
	}
}
