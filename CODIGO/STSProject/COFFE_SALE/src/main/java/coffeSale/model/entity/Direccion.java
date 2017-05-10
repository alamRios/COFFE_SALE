package coffeSale.model.entity;

import java.io.Serializable; 

public class Direccion implements Serializable{
	private static final long serialVersionUID = -361206277811930764L;
	
	private int id; 
	private String calle; 
	private String numero; 
	private String colonia; 
	private String delegacion; 
	private String ciudad; 
	private String pais; 
	
	public Direccion(){
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
