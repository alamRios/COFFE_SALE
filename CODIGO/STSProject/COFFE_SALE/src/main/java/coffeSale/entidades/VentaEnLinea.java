package coffeSale.entidades;

import java.util.ArrayList;
import java.util.Date;

public class VentaEnLinea implements Venta{
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
	public String toString() {
		return "VentaEnLinea [noVenta=" + noVenta + ", momentoVenta="
				+ momentoVenta + ", codigoAutorizacion=" + codigoAutorizacion
				+ "]";
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
}
