package com.coffeSale.model.dto;

import com.coffeSale.model.entity.MarcaEntity;

public class Marca {
	private String nombre;
	private String rfc; 
	
	public Marca(){
		this("","");
	}
	
	public Marca(String nombre, String rfc){
		super();
		this.nombre = nombre; 
		this.rfc = rfc; 
	}
	
	public Marca(MarcaEntity marca){
		this(
			marca.getNombre(),
			marca.getRfc()
		);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "MarcaDTO [nombre=" + nombre + ", rfc=" + rfc + "]";
	}
}
