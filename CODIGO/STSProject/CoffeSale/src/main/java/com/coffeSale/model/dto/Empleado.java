package com.coffeSale.model.dto;

public class Empleado {
	private String nombre; 
	private String apPaterno; 
	private String apMaterno; 
	private int codigoEmpleado;
	
	public Empleado(){
		this("","","",0);
	}
	
	public Empleado(String nombre, String apPaterno, String apMaterno,
			int codigoEmpleado) {
		super();
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.codigoEmpleado = codigoEmpleado;
	}
	
	public Empleado(Empleado empleado){
		this(
			empleado.nombre,
			empleado.apPaterno,
			empleado.apMaterno,
			empleado.codigoEmpleado
		);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apPaterno=" + apPaterno
				+ ", apMaterno=" + apMaterno + ", codigoEmpleado="
				+ codigoEmpleado + "]";
	} 
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof Empleado){
				Empleado empleado = (Empleado) obj; 
				if(empleado.codigoEmpleado == this.codigoEmpleado
					&& empleado.nombre.equals(this.nombre)
					&& empleado.apMaterno.equals(this.apMaterno)
					&& empleado.apPaterno.equals(this.apPaterno))
					return true; 
			}
		}
		return false; 
	}
}
