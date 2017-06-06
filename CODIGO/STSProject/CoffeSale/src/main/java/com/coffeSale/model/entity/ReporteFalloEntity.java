package com.coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REPORTE_FALLO")
public class ReporteFalloEntity implements Serializable{
	private static final long serialVersionUID = 4397978275390862241L;
	
	@Id
	@Column(name="REPORTE_FALLO_ID")
	private int id; 
	
	@Column(name="REPORTE_FALLO_CAFETERIA")
	private int cafeteria; 
	
	@Column(name="REPORTE_FALLO_DESCRIPCION")
	private String descripcion; 
	
	@Column(name="REPORTE_FALLO_EMPLEADO")
	private int empleado; 
	
	@Column(name="REPORTE_FALLO_ALTA")
	private Date fechaAlta; 
	
	@Column(name="REPORTE_FALLO_ATENCION")
	private Date fechaAtencion; 
	
	@Column(name="REPORTE_FALLO_SOLUCIONADO")
	private boolean solucionado; 
	
	public ReporteFalloEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(int cafeteria) {
		this.cafeteria = cafeteria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public boolean isSolucionado() {
		return solucionado;
	}

	public void setSolucionado(boolean solucionado) {
		this.solucionado = solucionado;
	}

	@Override
	public String toString() {
		return "ReporteFallo{id=" + id + ", cafeteria=" + cafeteria
				+ ", descripcion=" + descripcion + ", empleado=" + empleado
				+ ", fechaAlta=" + fechaAlta + ", fechaAtencion="
				+ fechaAtencion + ", solucionado=" + solucionado + "}";
	}
}
