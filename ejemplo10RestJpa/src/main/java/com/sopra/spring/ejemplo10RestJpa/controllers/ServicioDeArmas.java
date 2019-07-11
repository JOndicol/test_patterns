package com.sopra.spring.ejemplo10RestJpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.spring.ejemplo10RestJpa.model.dao.AlmacenDeArmas;
import com.sopra.spring.ejemplo10RestJpa.model.entities.Arma;

@RestController
public class ServicioDeArmas {
	
	@Autowired
	private AlmacenDeArmas almacen;
	
	
	public ServicioDeArmas() {
		super();
	}
	
	public ServicioDeArmas(AlmacenDeArmas almacen) {
		super();
		this.almacen = almacen;
	}

	@GetMapping("/armas")
	public List<Arma> armas(){
		return almacen.findAll();
	}
	
	@GetMapping("/armas/{id}")
	public Arma arma(@PathVariable Integer id) {
		return almacen.findById(id).orElse(null);
	}
	
	@PostMapping("/armas")
	public Arma agregarArmaAlInventario(@RequestBody Arma arma) {
		return almacen.save(arma);
	}
	
	@PutMapping("/armas/{id}")
	public Arma actualizarArma(@RequestBody Arma arma, @PathVariable Integer id) {
		return almacen.findById(id).map(clienteencontrado -> {
			clienteencontrado.setNombre(arma.getNombre());
			clienteencontrado.setCalibre(arma.getCalibre());
			return almacen.save(clienteencontrado);
		}).orElseGet(() -> {
			arma.setId(id);
			return almacen.save(arma);
		});
	}
	
	@DeleteMapping("/armas/{id}")
	public void venderArma(@PathVariable Integer id) {
		almacen.deleteById(id);
	}

	public AlmacenDeArmas getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenDeArmas almacen) {
		this.almacen = almacen;
	}
	
	
}
