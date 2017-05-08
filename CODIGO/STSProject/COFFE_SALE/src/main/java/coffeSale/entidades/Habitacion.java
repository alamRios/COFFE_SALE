package coffeSale.entidades;

public class Habitacion {
	private String uso;
	private double alto; 
	private double ancho; 
	private double largo;
	
	public Habitacion(){
		this("", 0.0, 0.0, 0.0);
	}
	public Habitacion(String uso, double alto, double ancho, double largo) {
		super();
		this.uso = uso;
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
	}
	public Habitacion(Habitacion habitacion){
		this(
			habitacion.uso,
			habitacion.alto,
			habitacion.ancho,
			habitacion.largo
		);
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	@Override
	public String toString() {
		return "Habitacion [uso=" + uso + ", alto=" + alto + ", ancho=" + ancho
				+ ", largo=" + largo + "]";
	} 
}
