package com.coffeSale.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DIRECCION")
public class DireccionEntity implements Serializable{
	private static final long serialVersionUID = -361206277811930764L;
	
	@Id
	@Column(name="DIRECCION_ID")
	private int id; 
	
	@Column(name="DIRECCION_CALLE")
	private String calle; 
	
	@Column(name="DIRECCION_NUMERO")
	private String numero; 
	
	@Column(name="DIRECCION_COLONIA")
	private String colonia; 
	
	@Column(name="DIRECCION_DELEGACION")
	private String delegacion; 
	
	@Column(name="DIRECCION_CIUDAD")
	private String ciudad; 
	
	@Column(name="DIRECCION_PAIS")
	private String pais; 
	
	public DireccionEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion{id=" + id + ", calle=" + calle + ", numero=" + numero
				+ ", colonia=" + colonia + ", delegacion=" + delegacion
				+ ", ciudad=" + ciudad + ", pais=" + pais + "}";
	}
}
