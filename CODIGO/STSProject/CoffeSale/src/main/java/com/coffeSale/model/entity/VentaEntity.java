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
import javax.persistence.Transient;

import com.coffeSale.model.dto.Venta;

@Entity 
@Table(name="VENTA")
public class VentaEntity implements Serializable{
	private static final long serialVersionUID = 7145142779203406704L;
	
	@Id
	@Column(name="VENTA_ID", columnDefinition = "serial")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="venta_venta_id_seq", name="venta_venta_id_seq")
	@GeneratedValue(generator="venta_venta_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="VENTA_PROMOCION")
	private int promocionId; 
	
	@Column(name="VENTA_CAFETERIA")
	private int cafeteriaId; 
	
	@Column(name="VENTA_EMPLEADO")
	private int empleadoId; 
	
	@Column(name="VENTA_CLIENTE")
	private int cliente; 
	
	@Column(name="VENTA_IMPORTE")
	private float importe; 
	
	@Column(name="VENTA_INICIO")
	private Date inicio; 
	
	@Column(name="VENTA_FIN")
	private Date fin; 
	
	@Column(name="VENTA_GAVETA_ID")
	private int gavetaId; 

	public VentaEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPromocionId() {
		return promocionId;
	}

	public void setPromocionId(int promocionId) {
		this.promocionId = promocionId;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	public int getGavetaId() {
		return gavetaId;
	}

	public void setGavetaId(int gavetaId) {
		this.gavetaId = gavetaId;
	}
	
	@Override
	public String toString() {
		return "VentaEntity{id=" + id + ", promocionId=" + promocionId
				+ ", cafeteriaId=" + cafeteriaId + ", empleadoId=" + empleadoId
				+ ", cliente=" + cliente + ", importe=" + importe + ", inicio="
				+ inicio + ", fin=" + fin + ", gavetaId=" + gavetaId +"}";
	}
}
