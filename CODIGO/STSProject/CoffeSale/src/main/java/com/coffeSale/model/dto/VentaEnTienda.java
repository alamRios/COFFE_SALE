package com.coffeSale.model.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class VentaEnTienda implements Venta{
	private static final long serialVersionUID = 9068652851637208891L;
	
	private Empleado vendedor; 
	private Gaveta gaveta;
	private double montoTotal;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date momentoVenta;
	
	public VentaEnTienda(){
		this(new Empleado(), new Gaveta(), 0.0, new Date());
	}
	public VentaEnTienda(Empleado vendedor, Gaveta gaveta, double montoTotal,
			Date momentoVenta) {
		super();
		this.vendedor = vendedor;
		this.gaveta = gaveta;
		this.montoTotal = montoTotal;
		this.momentoVenta = momentoVenta;
	}
	public VentaEnTienda(VentaEnTienda ventaEnTienda){
		this(
			ventaEnTienda.vendedor, 
			ventaEnTienda.gaveta,
			ventaEnTienda.montoTotal, 
			ventaEnTienda.momentoVenta
		);
	}
	
	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Gaveta getGaveta() {
		return gaveta;
	}

	public void setGaveta(Gaveta gaveta) {
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
		DateFormat df = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
		return "VentaEnTienda [vendedor=" + vendedor + ", gaveta=" + gaveta
				+ ", montoTotal=" + montoTotal + ", momentoVenta="
				+  df.format(momentoVenta)+ "]";
	}
	
	public boolean equals(Object obj){
		if(obj != null){
			if(obj instanceof VentaEnTienda){
				VentaEnTienda venta = (VentaEnTienda) obj; 
				if(venta.gaveta.equals(this.gaveta)
					&& venta.momentoVenta.equals(this.momentoVenta)
					&& venta.montoTotal == this.montoTotal
					&& venta.vendedor.equals(this.vendedor))
					return true; 
			}
		}return false; 
	}
}
