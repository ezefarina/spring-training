package org.ezefarina.spring.dao.impl;

import org.ezefarina.spring.dao.FacturaDao;
import org.ezefarina.spring.entities.Factura;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("facturaDao")
@Scope("singleton")
public class FacturaDaoImpl extends GenericDaoImpl<Factura, Long> implements FacturaDao {
	
	

}
