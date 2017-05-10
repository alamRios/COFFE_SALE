package coffeSale.model.entity;

import java.io.Serializable; 

public class Habitacion implements Serializable{
	private static final long serialVersionUID = 8191121982010540451L;
	
	private int id; 
	private String descripcion; 
	private String uso; 
	private float ancho; 
	private float largo; 
	
	public Habitacion(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Habitacion{id=" + id + ", descripcion=" + descripcion
				+ ", uso=" + uso + ", ancho=" + ancho + ", largo=" + largo
				+ "}";
	}
}
