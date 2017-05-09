package coffeSale.model.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class CafeteriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private PlantillaDTO plantilla; 
	private ArrayList<GavetaDTO> gavetas; 
	private ArrayList<VentaDTO> ventas; 
	private ArrayList<HabitacionDTO> habitaciones; 
	private InventarioDTO inventario; 
	private CajaFuerteDTO cajaFuerte; 
	private String nombre; 
	private String linea; 
	private String identificador;
	
	public CafeteriaDTO(){
		this(
			new PlantillaDTO(), 
			new ArrayList<>(),
			new ArrayList<>(),
			new ArrayList<>(),
			new InventarioDTO(), 
			new CajaFuerteDTO(),
			"", "", ""
		);
	}
	public CafeteriaDTO(PlantillaDTO plantilla, ArrayList<GavetaDTO> gavetas,
			ArrayList<VentaDTO> ventas, ArrayList<HabitacionDTO> habitaciones,
			InventarioDTO inventario, CajaFuerteDTO cajaFuerte, String nombre,
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
	public CafeteriaDTO(CafeteriaDTO cafeteria){
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

	public PlantillaDTO getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(PlantillaDTO plantilla) {
		this.plantilla = plantilla;
	}

	public ArrayList<GavetaDTO> getGavetas() {
		return gavetas;
	}

	public void setGavetas(ArrayList<GavetaDTO> gavetas) {
		this.gavetas = gavetas;
	}

	public ArrayList<VentaDTO> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<VentaDTO> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<HabitacionDTO> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<HabitacionDTO> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public InventarioDTO getInventario() {
		return inventario;
	}

	public void setInventario(InventarioDTO inventario) {
		this.inventario = inventario;
	}

	public CajaFuerteDTO getCajaFuerte() {
		return cajaFuerte;
	}

	public void setCajaFuerte(CajaFuerteDTO cajaFuerte) {
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
