package coffeSale.model.dto;

import java.util.ArrayList;
import java.util.Date;

public class VentaEnLineaDTO implements VentaDTO{
	private String noVenta;
	private Date momentoVenta;
	private String codigoAutorizacion;
	
	public VentaEnLineaDTO(){
		this("", new Date(), "");
	}
	public VentaEnLineaDTO(String noVenta, Date momentoVenta,
			String codigoAutorizacion) {
		super();
		this.noVenta = noVenta;
		this.momentoVenta = momentoVenta;
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public VentaEnLineaDTO(VentaEnLineaDTO ventaEnLinea){
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
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos) {
		// TODO Auto-generated method stub
	}

	@Override
	public void registrarVenta(double montoTotal,
			ArrayList<ProductoDTO> productos, MembresiaClienteDTO membresia) {
		// TODO Auto-generated method stub
	} 
}