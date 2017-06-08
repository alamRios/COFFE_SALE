package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DET_VENTA")
public class DetalleVentaEntity implements Serializable{
	private static final long serialVersionUID = -838827074339573060L;
	
	@Id
	@Column(name="DET_VENTA_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="det_venta_det_venta_id_seq", name="det_venta_det_venta_id_seq")
	@GeneratedValue(generator="det_venta_det_venta_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="DET_VENTA_VENTA")
	private int ventaId; 
	
	@Column(name="DET_VENTA_PRODUCTO")
	private int productoId;
	
	@Column(name="DET_VENTA_PRECIO_UNITARIO")
	private double precioUnitario; 
	
	public DetalleVentaEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVentaId() {
		return ventaId;
	}

	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetalleVenta{id=" + id + ", ventaId=" + ventaId
				+ ", productoId=" + productoId + ", precioUnitario="
				+ precioUnitario + "}";
	}
}
