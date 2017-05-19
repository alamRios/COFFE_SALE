package com.coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class VentaEnTiendaDTO implements VentaDTO{
	private static final long serialVersionUID = 9068652851637208891L;
	
	private EmpleadoDTO vendedor; 
	private GavetaDTO gaveta;
	private double montoTotal;
	private Date momentoVenta;
	
	public VentaEnTiendaDTO(){
		this(new EmpleadoDTO(), new GavetaDTO(), 0.0, new Date());
	}
	public VentaEnTiendaDTO(EmpleadoDTO vendedor, GavetaDTO gaveta, double montoTotal,
			Date momentoVenta) {
		super();
		this.vendedor = vendedor;
		this.gaveta = gaveta;
		this.montoTotal = montoTotal;
		this.momentoVenta = momentoVenta;
	}
	public VentaEnTiendaDTO(VentaEnTiendaDTO ventaEnTienda){
		this(
			ventaEnTienda.vendedor, 
			ventaEnTienda.gaveta,
			ventaEnTienda.montoTotal, 
			ventaEnTienda.momentoVenta
		);
	}

	public EmpleadoDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(EmpleadoDTO vendedor) {
		this.vendedor = vendedor;
	}

	public GavetaDTO getGaveta() {
		return gaveta;
	}

	public void setGaveta(GavetaDTO gaveta) {
		this.gaveta = gaveta;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getMomentoVenta() {
		return momentoVenta;
	}

	public void setMomentoVenta(Date momentoVenta) {
		this.momentoVenta = momentoVenta;
	}
	
	@Override
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos) {
		// TODO Auto-generated method stub
	}

	@Override
	public void registrarVenta(double montoTotal,
			ArrayList<ProductoDTO> productos, MembresiaClienteDTO membresia) {
		// TODO Auto-generated method stub
	} 	

	@Override
	public String toString() {
		return "VentaEnTienda [vendedor=" + vendedor + ", gaveta=" + gaveta
				+ ", montoTotal=" + montoTotal + ", momentoVenta="
				+ momentoVenta + "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof VentaEnTiendaDTO){
				VentaEnTiendaDTO venta = (VentaEnTiendaDTO) obj; 
				if(venta.gaveta.equals(this.gaveta)
					&& venta.momentoVenta.equals(this.momentoVenta)
					&& venta.montoTotal == this.montoTotal
					&& venta.vendedor.equals(this.vendedor))
					return true; 
			}
		}return false; 
	}
}
