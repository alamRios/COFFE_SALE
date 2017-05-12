package com.coffeSale.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public interface VentaDTO extends Serializable{
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos);
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos, MembresiaClienteDTO membresia);
}
