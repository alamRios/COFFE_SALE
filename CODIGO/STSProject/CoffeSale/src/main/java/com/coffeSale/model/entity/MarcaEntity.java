package com.coffeSale.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.coffeSale.model.dto.Marca;

@Entity
@Table(name="MARCA")
public class MarcaEntity implements Serializable{
	private static final long serialVersionUID = 4881519404543198107L;
	
	@Id
	@Column(name="MARCA_ID", columnDefinition = "serial")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="marca_marca_id_seq", name="marca_marca_id_seq")
	@GeneratedValue(generator="marca_marca_id_seq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="MARCA_NOMBRE")
	private String nombre; 
	
	@Column(name="MARCA_RFC")
	private String rfc; 
	
	public MarcaEntity(){
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

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + ", rfc=" + rfc + "]";
	}

	@Transient
	public Marca getMarca() {
		return new Marca(this.nombre,this.rfc);
	}
}
