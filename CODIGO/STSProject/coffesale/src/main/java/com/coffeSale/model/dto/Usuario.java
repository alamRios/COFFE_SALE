package com.coffeSale.model.dto;

public class Usuario {
	private String nombre; 
	private int lineaId; 
	private String password;
	
	public Usuario(){
		this("",0,"");
	}
	
	public Usuario(String nombre, int lineaId, String password){
		this.nombre = nombre; 
		this.lineaId = lineaId; 
		this.password = password; 
	}
	
	public Usuario(Usuario usuario){
		this(usuario.nombre, usuario.lineaId, usuario.password);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLineaId() {
		return lineaId;
	}

	public void setLineaId(int lineaId) {
		this.lineaId = lineaId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", lineaId=" + lineaId + ", password=" + password + "]";
	}
	
	public boolean equals(Object objeto){
		if(objeto!=null)
			if(objeto instanceof Usuario){
				Usuario usuario = (Usuario) objeto;
				if(usuario.getLineaId() == this.lineaId &&
					usuario.getNombre().equals(this.nombre) &&
					usuario.getPassword().equals(this.password))
					return true; 
			}
		return false; 
	}
}
