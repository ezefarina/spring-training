package org.ezefarina.spring.service.impl;

import java.util.List;

import org.ezefarina.spring.repository.ArticuloRepository;
import org.ezefarina.spring.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.ezefarina.spring.entities.Articulo;

@Service(value = "articuloService")
@Scope(value = "prototype")
public class ArticuloServiceImpl implements ArticuloService {

  @Autowired
  private ArticuloRepository articuloRepository;

  @Override
  public Articulo salvarArticulo(Articulo articulo) {
    return articuloRepository.save(articulo);
  }

  @Override
  public void borrarArticulo(Articulo articulo) {
    articuloRepository.delete(articulo);
  }

  @Override
  public List<Articulo> listarArticulos() {
    return articuloRepository.findAll();
  }

  @Override
  public Articulo obtenerPorId(Long id) {
    return articuloRepository.findOne(id);
  }

  @Override
  public void modificarArticulo(Articulo articulo) {
    articuloRepository.save(articulo);
  }

}
