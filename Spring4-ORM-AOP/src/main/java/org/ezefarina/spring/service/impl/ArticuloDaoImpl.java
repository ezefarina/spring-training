package org.ezefarina.spring.service.impl;

import java.util.List;

import org.ezefarina.spring.dao.ArticuloDao;
import org.ezefarina.spring.entities.Articulo;
import org.ezefarina.spring.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value="articuloDaoImpl")
@Scope(value="prototype")
public class ArticuloDaoImpl implements ArticuloService {

	@Autowired
	private ArticuloDao articuloDao;
	
	
	@Override
	public Articulo salvarArticulo(Articulo articulo) {
	    Long id = articuloDao.save(articulo);
	    articulo.setId(id);
		return articulo;
	}

	@Override
	public void borrarArticulo(Articulo articulo) {
		articuloDao.delete(articulo);
	}

	@Override
	public List<Articulo> listarArticulos() {
		
		return articuloDao.findAll();
	}

	@Override
	public Articulo obtenerPorId(Long id) {
		
		return articuloDao.getById(id);
	}

	@Override
	public void modificarArticulo(Articulo articulo) {
		articuloDao.saveOrUpdate(articulo);
		
	}

}
