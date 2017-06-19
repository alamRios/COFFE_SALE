package com.coffeSale.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MembresiaCliente {
	private String nombre;
	private int noCliente;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaAlta; 
	private String email;
	
	public MembresiaCliente(){
		this("", 0, new Date(),"");
	}
	public MembresiaCliente(String nombre, int noCliente, Date fechaAlta,
		String email) {
		super();
		this.nombre = nombre;
		this.noCliente = noCliente;
		this.fechaAlta = fechaAlta;
		this.email = email;
	}
	public MembresiaCliente(MembresiaCliente membresiaCliente){
		this(
			membresiaCliente.nombre, 
			membresiaCliente.noCliente,
			membresiaCliente.fechaAlta,
			membresiaCliente.email
		);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNoCliente() {
		return noCliente;
	}

	public void setNoCliente(int noCliente) {
		this.noCliente = noCliente;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	@Override
	public String toString() {
		return "MembresiaCliente [nombre=" + nombre + ", noCliente="
				+ noCliente + ", fechaAlta=" + fechaAlta + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof MembresiaCliente){
				MembresiaCliente membresia = (MembresiaCliente) obj; 
				if(membresia.fechaAlta.equals(this.fechaAlta)
					&& membresia.noCliente == this.noCliente
					&& membresia.nombre.equals(this.nombre))
					return true; 
			}				
		}
		return false; 
	}
}
