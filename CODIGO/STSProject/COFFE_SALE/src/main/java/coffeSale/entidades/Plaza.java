package coffeSale.entidades;

public class Plaza {
	private Empleado empleado; 
	private String identificador;
	private boolean activa;
	
	public Plaza(){
		this(new Empleado(), "", true);
	}
	public Plaza(Empleado empleado, String identificador, boolean activa) {
		super();
		this.empleado = empleado;
		this.identificador = identificador;
		this.activa = activa;
	}
	public Plaza(Plaza plaza){
		this(
			plaza.empleado,
			plaza.identificador,
			plaza.activa
		);
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Override
	public String toString() {
		return "Plaza [empleado=" + empleado + ", identificador="
				+ identificador + ", activa=" + activa + "]";
	} 
}
