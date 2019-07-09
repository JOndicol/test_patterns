package com.sopra.spring.ejemplo03anotaciones.model.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.spring.ejemplo03anotaciones.model.dao.FacturasDao;
import com.sopra.spring.ejemplo03anotaciones.model.entities.Factura;

@Service
public class GestionFacturas {
	
	@Autowired
	private FacturasDao facturasDao;

	public Boolean guardarFactura(Factura factura) {
		return facturasDao.addFactura(factura);
	}
	
	public List<Factura> dameFacturas(){
		return facturasDao.getFacturas();
	}
	
	public FacturasDao getFacturasDao() {
		return facturasDao;
	}

	public void setFacturasDao(FacturasDao facturasDao) {
		this.facturasDao = facturasDao;
	}
	
}
