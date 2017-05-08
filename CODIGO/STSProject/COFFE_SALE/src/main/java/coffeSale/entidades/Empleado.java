package coffeSale.entidades;

public class Empleado {
	private String nombre; 
	private String apPaterno; 
	private String apMaterno; 
	private String codigoEmpleado;
	
	public Empleado(){
		this("","","","");
	}
	
	public Empleado(String nombre, String apPaterno, String apMaterno,
			String codigoEmpleado) {
		super();
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.codigoEmpleado = codigoEmpleado;
	}
	
	public Empleado(Empleado empleado){
		this(
			empleado.nombre,
			empleado.apPaterno,
			empleado.apMaterno,
			empleado.codigoEmpleado
		);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apPaterno=" + apPaterno
				+ ", apMaterno=" + apMaterno + ", codigoEmpleado="
				+ codigoEmpleado + "]";
	} 
}
