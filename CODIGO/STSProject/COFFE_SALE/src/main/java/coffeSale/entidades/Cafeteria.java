package coffeSale.entidades;

import java.util.ArrayList;

public class Cafeteria {
	private Plantilla plantilla; 
	private ArrayList<Gaveta> gavetas; 
	private ArrayList<Venta> ventas; 
	private ArrayList<Habitacion> habitaciones; 
	private Inventario inventario; 
	private CajaFuerte cajaFuerte; 
	private String nombre; 
	private String linea; 
	private String identificador;
	
	public Cafeteria(){
		this(
			new Plantilla(), 
			new ArrayList<>(),
			new ArrayList<>(),
			new ArrayList<>(),
			new Inventario(), 
			new CajaFuerte(),
			"", "", ""
		);
	}
	public Cafeteria(Plantilla plantilla, ArrayList<Gaveta> gavetas,
			ArrayList<Venta> ventas, ArrayList<Habitacion> habitaciones,
			Inventario inventario, CajaFuerte cajaFuerte, String nombre,
			String linea, String identificador) {
		super();
		this.plantilla = plantilla;
		this.gavetas = gavetas;
		this.ventas = ventas;
		this.habitaciones = habitaciones;
		this.inventario = inventario;
		this.cajaFuerte = cajaFuerte;
		this.nombre = nombre;
		this.linea = linea;
		this.identificador = identificador;
	}
	public Cafeteria(Cafeteria cafeteria){
		this(
			cafeteria.plantilla, 
			cafeteria.gavetas, 
			cafeteria.ventas, 
			cafeteria.habitaciones, 
			cafeteria.inventario, 
			cafeteria.cajaFuerte, 
			cafeteria.nombre, 
			cafeteria.linea, 
			cafeteria.identificador
		);
	}

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	public ArrayList<Gaveta> getGavetas() {
		return gavetas;
	}

	public void setGavetas(ArrayList<Gaveta> gavetas) {
		this.gavetas = gavetas;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public CajaFuerte getCajaFuerte() {
		return cajaFuerte;
	}

	public void setCajaFuerte(CajaFuerte cajaFuerte) {
		this.cajaFuerte = cajaFuerte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public String toString() {
		return "Cafeteria [plantilla=" + plantilla + ", gavetas=" + gavetas
				+ ", ventas=" + ventas + ", habitaciones=" + habitaciones
				+ ", inventario=" + inventario + ", cajaFuerte=" + cajaFuerte
				+ ", nombre=" + nombre + ", linea=" + linea
				+ ", identificador=" + identificador + "]";
	} 	
}
