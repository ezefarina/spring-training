package org.ezefarina.spring.service.impl;

import org.ezefarina.spring.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import org.ezefarina.spring.entities.Factura;
import org.ezefarina.spring.service.FacturaService;

@Service(value="facturaService")
@Scope(value="prototype")
public class FacturaServiceImpl implements FacturaService {

  @Autowired
	private FacturaRepository facturaRepository;

	@Override
	public Long crearFactura(Factura factura) {
		return facturaRepository.save(factura).getId();
	}

}
