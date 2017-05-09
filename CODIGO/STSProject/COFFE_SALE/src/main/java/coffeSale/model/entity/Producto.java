package coffeSale.model.entity;

import java.io.Serializable;

public class Producto implements Serializable{
	private static final long serialVersionUID = -8738715846179084757L;
	
	private int id; 
	private String nombre; 
	private float costo; 
	
	public Producto(){
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Producto{id=" + id + ", nombre=" + nombre + ", costo=" + costo
				+ "}";
	}
}
