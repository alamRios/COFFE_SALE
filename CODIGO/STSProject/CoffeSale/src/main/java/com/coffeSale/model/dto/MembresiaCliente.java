package com.coffeSale.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MembresiaCliente {
	private String nombre;
	private String noCliente;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fechaAlta; 
	private String email;
	
	public MembresiaCliente(){
		this("", "", new Date(),"");
	}
	public MembresiaCliente(String nombre, String noCliente, Date fechaAlta,
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

	public String getNoCliente() {
		return noCliente;
	}

	public void setNoCliente(String noCliente) {
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
					&& membresia.noCliente.equals(this.noCliente)
					&& membresia.nombre.equals(this.nombre))
					return true; 
			}				
		}
		return false; 
	}
}