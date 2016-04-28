package org.ezefarina.spring.service;

import org.ezefarina.spring.entities.Articulo;

import java.util.List;

public interface ArticuloService {
	
	Articulo salvarArticulo(Articulo articulo);
	
	void borrarArticulo(Articulo articulo);
	
	List<Articulo> listarArticulos();
	
	Articulo obtenerPorId(Long id);
	
	void modificarArticulo(Articulo articulo);
	
}
