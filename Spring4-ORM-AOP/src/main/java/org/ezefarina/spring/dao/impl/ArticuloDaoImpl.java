package org.ezefarina.spring.dao.impl;

import org.ezefarina.spring.dao.ArticuloDao;
import org.ezefarina.spring.entities.Articulo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("articuloDao")
@Scope("singleton")
public class ArticuloDaoImpl extends GenericDaoImpl<Articulo, Long> implements ArticuloDao {

}
