package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sopra.java.Patterns.model.entities.Aula;

public class MemoryMapAulaDao implements IDao<Aula>{

	private Map<String, Aula> miMapa;
	
	public MemoryMapAulaDao(Map<String, Aula> miMapa) {
		super();
		this.miMapa = miMapa;
	}

	@Override
	public void insert(Aula aula) {
		miMapa.putIfAbsent(aula.getNombreAula(), aula);
	}

	@Override
	public Aula update(Aula aula) {
		return miMapa.replace(aula.getNombreAula(), aula);
	}

	@Override
	public void delete(Aula aula) {
		miMapa.remove(aula.getNombreAula());
	}

	@Override
	public Collection<Aula> list() {
		return miMapa.values();
	}

	@Override
	public Collection<Aula> search(Aula aula) {
		Collection<Aula> coleccion = new ArrayList<>();
		if(miMapa.containsKey(aula.getNombreAula()))
			coleccion.add(miMapa.get(aula.getNombreAula()));
		return coleccion;
	}

}
