package coffeSale.model.entity;

import java.io.Serializable;

public class Cafeteria implements Serializable{
	private static final long serialVersionUID = -9019107116825708383L;
	
	private int id; 
	private String nombre; 
	private boolean aceptaMembresias; 
	private String estado; 
	private String email; 
	private int direccionId;
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
