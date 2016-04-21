package org.ezefarina.spring.service.impl;

import org.ezefarina.spring.dao.FacturaDao;
import org.ezefarina.spring.entities.Factura;
import org.ezefarina.spring.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service(value="facturaService")
@Scope(value="prototype")
public class FacturaServiceImpl implements FacturaService {

    @Autowired
	private FacturaDao facturaDao;

	public FacturaDao getFacturaDao() {
		return facturaDao;
	}

	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}


	@Override
  @Transactional
	public Long crearFactura(Factura factura) {
		Long id = facturaDao.save(factura);
		return id; 
		
	}



	
}
