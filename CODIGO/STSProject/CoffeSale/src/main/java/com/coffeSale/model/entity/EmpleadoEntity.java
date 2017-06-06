package com.coffeSale.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coffeSale.model.dto.Empleado;

@Entity 
@Table(name="EMPLEADO")
public class EmpleadoEntity implements Serializable{
	private static final long serialVersionUID = -2055483235949311482L;
	
	@Id
	@Column(name="EMPLEADO_ID")
	private int id; 
	
	@Column(name="EMPLEADO_PUESTO")
	private int puestoId; 
	
	@Column(name="EMPLEADO_HORARIO")
	private int horarioId; 
	
	@Column(name="EMPLEADO_CORREO")
	private String correo; 
	
	@Column(name="EMPLEADO_NOMBRE")
	private String nombre; 
	
	@Column(name="EMPLEADO_APPAT")
	private String appat; 
	
	@Column(name="EMPLEADO_APMAT")
	private String apmat; 
	
	@Column(name="EMPLEADO_CONTRATACION")
	private Date contratacion;
	
	@Column(name="EMPLEADO_SALARIO")
	private float salario; 
	
	public EmpleadoEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuestoId() {
		return puestoId;
	}

	public void setPuestoId(int puestoId) {
		this.puestoId = puestoId;
	}

	public int getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(int horarioId) {
		this.horarioId = horarioId;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppat() {
		return appat;
	}

	public void setAppat(String appat) {
		this.appat = appat;
	}

	public String getApmat() {
		return apmat;
	}

	public void setApmat(String apmat) {
		this.apmat = apmat;
	}

	public Date getContratacion() {
		return contratacion;
	}

	public void setContratacion(Date contratacion) {
		this.contratacion = contratacion;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado{id=" + id + ", puestoId=" + puestoId
				+ ", horarioId=" + horarioId + ", correo=" + correo
				+ ", nombre=" + nombre + ", appat=" + appat + ", apmat="
				+ apmat + ", contratacion=" + contratacion + ", salario="
				+ salario + "}";
	}
	
	@Transient
	public Empleado getEmpleado() {
		return new Empleado(
				this.nombre,
				this.appat,
				this.apmat,
				String.valueOf(this.id)
				);
	}
	
	
}
