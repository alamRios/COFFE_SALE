package com.coffeSale.model.entity;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLAZA")
public class PlazaEntity implements Serializable{
	private static final long serialVersionUID = 5974319249882759707L;
	
	@Id
	@Column(name="PLAZA_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="plaza_plaza_id_seq", name="plaza_plaza_id_seq")
	@GeneratedValue(generator="plaza_plaza_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Id
	@Column(name="PLAZA_FOLIO")
	private int folio; 
	
	@Id
	@Column(name="PLAZA_EMPLEADO")
	private int empleadoId; 
	
	@Id
	@Column(name="PLAZA_FECHA_ALTA")
	private Date fechaAlta; 
	
	@Id
	@Column(name="PLAZA_FECHA_ACTUALIZACION")
	private Date fechaActualizacion;
	
	@Id
	@Column(name="PLAZA_ACTIVA")
	private boolean activa; 
	
	@Id
	@Column(name="PLAZA_PLANTILLA")
	private int plantillaId;
	
	public PlazaEntity(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public int getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public int getPlantillaId() {
		return plantillaId;
	}
	public void setPlantillaId(int plantillaId) {
		this.plantillaId = plantillaId;
	}

	@Override
	public String toString() {
		return "Plaza{id=" + id + ", folio=" + folio + ", empleadoId="
				+ empleadoId + ", fechaAlta=" + fechaAlta
				+ ", fechaActualizacion=" + fechaActualizacion + ", activa="
				+ activa + ", plantillaId=" + plantillaId + "}";
	} 
}
