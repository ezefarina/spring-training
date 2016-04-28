package org.ezefarina.spring.beans;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.ezefarina.spring.entities.Articulo;
import org.ezefarina.spring.service.ArticuloService;

@Component("articuloBean")
@Scope("session")
public class ArticuloBean {
	
    private String nombre ;
	private String presentacion;
	private Float precio;
	private Integer cantidad;
	

	
	
	@Autowired
	private ArticuloService articuloService;
	
	private List<Articulo> articulos ;
	
	public ArticuloBean() {
		super();
	}
	
	@PostConstruct
	public void init() {
		articulos = articuloService.listarArticulos();
	}
	
	public void guardarArticulo(){
	  Articulo articulo = new Articulo(nombre, presentacion, precio, cantidad);
	  articuloService.salvarArticulo(articulo);
	  articulos = articuloService.listarArticulos();
	}
	

	
	
	public String getNombre() {
		return nombre;
		
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public ArticuloService getArticuloService() {
		return articuloService;
	}

	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}


	
	
	

}
