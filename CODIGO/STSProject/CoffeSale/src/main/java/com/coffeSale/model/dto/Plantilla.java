package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {
	private List<Plaza> plazas;
	private String identificador; 
	private int noPlazas;
	
	public Plantilla() {
		this(new ArrayList<Plaza>(), "", 0);
	}
	public Plantilla(List<Plaza> plazas, String identificador, int noPlazas) {
		super();
		this.plazas = plazas;
		this.identificador = identificador;
		this.noPlazas = noPlazas;
	}
	public Plantilla(Plantilla plantilla){
		this(
			plantilla.plazas,
			plantilla.identificador,
			plantilla.noPlazas
		);
	}

	public List<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getNoPlazas() {
		return noPlazas;
	}

	public void setNoPlazas(int noPlazas) {
		this.noPlazas = noPlazas;
	}

	@Override
	public String toString() {
		return "PlantillaDTO{plazas=" + plazas + ", identificador="
				+ identificador + ", noPlazas=" + noPlazas + "}";
	}
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Plantilla){
				Plantilla plantilla = (Plantilla)obj; 
				if(plantilla.identificador.equals(this.identificador)
					&& plantilla.noPlazas == this.noPlazas){
					for(Plaza plaza : plantilla.plazas)
						if(!this.plazas.contains(plaza)){
							return false;
						}
					return true; 
				}					
			}				
		}return false; 
	}
}
