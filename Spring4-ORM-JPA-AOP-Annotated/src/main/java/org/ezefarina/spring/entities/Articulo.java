package org.ezefarina.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articulos")
public class Articulo implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String presentacion;
	private Float precio;
	private Integer cantidad;
	
	

	public Articulo(String nombre, String presentacion, Float precio,Integer cantidad) {
		super();
		this.nombre = nombre;
		this.presentacion = presentacion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Articulo() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="presentacion")
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	@Column(name="cantidad")
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name="precio",nullable=false)
	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", presentacion="
				+ presentacion + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}
	
	
	

}
