package com.coffeSale.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public interface Venta extends Serializable{
	public void registrarVenta(double montoTotal, ArrayList<Producto> productos);
	public void registrarVenta(double montoTotal, ArrayList<Producto> productos, MembresiaCliente membresia);
}
