package com.coffeSale.util;

public class ServerResponse {
	private String mensaje; 
	private boolean procesoTerminado;
	
	public ServerResponse(){
		this("Respuesta del servidor",false);
	}
	public ServerResponse(String mensaje, 
			boolean procesoTerminado){
		this.mensaje = mensaje; 
		this.procesoTerminado = procesoTerminado; 
	}
	public ServerResponse(ServerResponse response){
		this(
			response.mensaje, 
			response.procesoTerminado
		);
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isProcesoTerminado() {
		return procesoTerminado;
	}
	public void setProcesoTerminado(boolean procesoTerminado) {
		this.procesoTerminado = procesoTerminado;
	}
	@Override
	public String toString() {
		return "ServerResponse [mensaje=" + mensaje + ", procesoTerminado=" + procesoTerminado + "]";
	}
	
	
}
