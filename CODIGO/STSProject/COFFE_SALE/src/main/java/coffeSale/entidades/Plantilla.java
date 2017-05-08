package coffeSale.entidades;

import java.util.ArrayList;

public class Plantilla {
	private ArrayList<Plaza> plazas; 
	private String identificador; 
	private int noPlazas;
	
	public Plantilla(){
		this(new ArrayList<>(), "", 0);
	}
	public Plantilla(ArrayList<Plaza> plazas, String identificador, int noPlazas) {
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

	public ArrayList<Plaza> getPlazas() {
		return plazas;
	}

	public void setPlazas(ArrayList<Plaza> plazas) {
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
		return "Plantilla [plazas=" + plazas + ", identificador="
				+ identificador + ", noPlazas=" + noPlazas + "]";
	} 
}
