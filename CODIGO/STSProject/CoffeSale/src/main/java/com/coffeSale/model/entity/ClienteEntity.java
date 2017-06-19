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

import com.coffeSale.model.dto.MembresiaCliente;

@Entity 
@Table(name="CLIENTE")
public class ClienteEntity implements Serializable{
	private static final long serialVersionUID = 3661590877343683715L;
	
	@Id
	@Column(name="CLIENTE_ID")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="cliente_cliente_id_seq", name="cliente_cliente_id_seq")
	@GeneratedValue(generator="cliente_cliente_id_seq", strategy=GenerationType.SEQUENCE)
	private int id; 
	
	@Column(name="CLIENTE_NOMBRE")
	private String nombre; 
	
	@Column(name="CLIENTE_APPAT")
	private String appat; 
	
	@Column(name="CLIENTE_APMAT")
	private String apmat; 
	
	@Column(name="CLIENTE_EMAIL")
	private String email; 
	
	@Column(name="CLIENTE_CAFETERIA")
	private int cafeteriaId; 
	
	@Column(name="CLIENTE_FECHA_ALTA")
	private Date fechaAlata; 
	
	@Column(name="CLIENTE_ACTIVO")
	private boolean activo; 
	
	public ClienteEntity(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCafeteriaId() {
		return cafeteriaId;
	}

	public void setCafeteriaId(int cafeteriaId) {
		this.cafeteriaId = cafeteriaId;
	}

	public Date getFechaAlata() {
		return fechaAlata;
	}

	public void setFechaAlata(Date fechaAlata) {
		this.fechaAlata = fechaAlata;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente{id=" + id + ", nombre=" + nombre + ", appat=" + appat
				+ ", apmat=" + apmat + ", email=" + email + ", cafeteriaId="
				+ cafeteriaId + ", fechaAlata=" + fechaAlata + ", activo="
				+ activo + "}";
	}

	public MembresiaCliente getCliente() {
		return new MembresiaCliente(
				this.nombre +" "+ this.appat +" "+ this.apmat,
				this.id,
				this.fechaAlata,
				this.email
		);
	}
}
