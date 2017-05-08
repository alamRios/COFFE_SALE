package coffeSale.entidades;

import java.util.ArrayList;

public interface Venta {
	public void registrarVenta(double montoTotal, ArrayList<Producto> productos);
	public void registrarVenta(double montoTotal, ArrayList<Producto> productos, MembresiaCliente membresia);
}
