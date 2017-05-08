package coffeSale.entidades;

import java.util.ArrayList;
import java.util.Date;

public class VentaEnTienda implements Venta{
	private Empleado vendedor; 
	private Gaveta gaveta;
	private double montoTotal;
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

	public Date getMomentoVenta() {
		return momentoVenta;
	}

	public void setMomentoVenta(Date momentoVenta) {
		this.momentoVenta = momentoVenta;
	}

	@Override
	public String toString() {
		return "VentaEnTienda [vendedor=" + vendedor + ", gaveta=" + gaveta
				+ ", montoTotal=" + montoTotal + ", momentoVenta="
				+ momentoVenta + "]";
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
