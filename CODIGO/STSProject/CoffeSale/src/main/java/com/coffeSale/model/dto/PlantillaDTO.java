package com.coffeSale.model.dto;

import java.util.ArrayList;

public class PlantillaDTO {
	private ArrayList<PlazaDTO> plazas; 
	private String identificador; 
	private int noPlazas;
	
	public PlantillaDTO(){
		this(new ArrayList<PlazaDTO>(), "", 0);
	}
	public PlantillaDTO(ArrayList<PlazaDTO> plazas, String identificador, int noPlazas) {
		super();
		this.plazas = plazas;
		this.identificador = identificador;
		this.noPlazas = noPlazas;
	}
	public PlantillaDTO(PlantillaDTO plantilla){
		this(
			plantilla.plazas,
			plantilla.identificador,
			plantilla.noPlazas
		);
	}

	public ArrayList<PlazaDTO> getPlazas() {
		return plazas;
	}

	public void setPlazas(ArrayList<PlazaDTO> plazas) {
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
			if(obj instanceof PlantillaDTO){
				PlantillaDTO plantilla = (PlantillaDTO)obj; 
				if(plantilla.identificador.equals(this.identificador)
					&& plantilla.noPlazas == this.noPlazas){
					for(PlazaDTO plaza : plantilla.plazas)
						if(!this.plazas.contains(plaza)){
							return false;
						}
					return true; 
				}					
			}				
		}return false; 
	}
}
