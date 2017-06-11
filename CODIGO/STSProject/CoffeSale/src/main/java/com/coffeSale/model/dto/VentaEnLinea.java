package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;

public class VentaEnLinea implements Venta{
	private static final long serialVersionUID = 5521698756416788361L;
	
	private String noVenta;
	private Date momentoVenta;
	private String codigoAutorizacion;
	
	public VentaEnLinea(){
		this("", new Date(), "");
	}
	public VentaEnLinea(String noVenta, Date momentoVenta,
			String codigoAutorizacion) {
		super();
		this.noVenta = noVenta;
		this.momentoVenta = momentoVenta;
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public VentaEnLinea(VentaEnLinea ventaEnLinea){
		this(
			ventaEnLinea.noVenta,
			ventaEnLinea.momentoVenta,
			ventaEnLinea.codigoAutorizacion
		);
	}

	public String getNoVenta() {
		return noVenta;
	}

	public void setNoVenta(String noVenta) {
		this.noVenta = noVenta;
	}
	
	public Date getMomentoVenta() {
		return momentoVenta;
	}
	
	public void setMomentoVenta(Date momentoVenta) {
		this.momentoVenta = momentoVenta;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	

	@Override
	public void registrarVenta(double montoTotal, ArrayList<Producto> productos) {
		// TODO Auto-generated method stub
	}

	@Override
	public void registrarVenta(double montoTotal,
			ArrayList<Producto> productos, MembresiaCliente membresia) {
		// TODO Auto-generated method stub
	} 

	@Override
	public String toString() {
		return "VentaEnLinea [noVenta=" + noVenta + ", momentoVenta="
				+ momentoVenta + ", codigoAutorizacion=" + codigoAutorizacion
				+ "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof VentaEnLinea){
				VentaEnLinea venta = (VentaEnLinea) obj; 
				if(venta.codigoAutorizacion.equals(this.codigoAutorizacion)
					&& venta.momentoVenta.equals(this.momentoVenta)
					&& venta.noVenta.equals(this.noVenta))
					return true; 
			}
		}return false; 
	}

}
