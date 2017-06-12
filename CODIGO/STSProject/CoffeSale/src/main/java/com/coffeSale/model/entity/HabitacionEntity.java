package com.coffeSale.model.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.coffeSale.model.dto.Habitacion;

@Entity
@Table(name="HABITACION")
public class HabitacionEntity implements Serializable{
	private static final long serialVersionUID = 8191121982010540451L;
	
	@Id
	@Column(name = "HABITACION_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="habitacion_habitacion_id_seq", name="habitacion_habitacion_id_seq")
	@GeneratedValue(generator="habitacion_habitacion_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name = "HABITACION_DESCRIPCION")
	private String descripcion; 
	
	@Column(name = "HABITACION_USO")
	private String uso; 
	
	@Column(name = "HABITACION_TAMANO_ANCHO")
	private float ancho; 
	
	@Column(name = "HABITACION_TAMANO_LARGO")
	private float largo; 
	
	@Column(name = "HABITACION_CAFETERIA")
	private int cafeteriaId; 

	public HabitacionEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}
	
	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	@Override
	public String toString() {
		return "Habitacion{id=" + id + ", descripcion=" + descripcion
				+ ", uso=" + uso + ", ancho=" + ancho + ", largo=" + largo
				+ ", cafeteria=" + cafeteriaId + "}";
	}

	public Habitacion getHabitacion() {
		return new Habitacion(
			this.uso,
			this.descripcion,
			this.ancho,
			this.largo
		);
	}

	
}