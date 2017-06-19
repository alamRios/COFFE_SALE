package com.coffeSale.model.dto;

public class Empleado {
	private String nombre; 
	private String apPaterno; 
	private String apMaterno; 
	private String puesto; 
	private String correo; 
	private int codigoEmpleado;
	
	public Empleado(){
		this("","","",0,"","");
	}
	
	public Empleado(String nombre, String apPaterno, String apMaterno,
			int codigoEmpleado, String puesto, String correo) {
		super();
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.codigoEmpleado = codigoEmpleado;
		this.puesto = puesto; 
		this.correo = correo; 
	}
	
	public Empleado(Empleado empleado){
		this(
			empleado.nombre,
			empleado.apPaterno,
			empleado.apMaterno,
			empleado.codigoEmpleado,
			empleado.puesto, 
			empleado.correo
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
