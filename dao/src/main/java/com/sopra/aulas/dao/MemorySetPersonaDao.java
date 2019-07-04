package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sopra.java.Patterns.model.entities.Persona;

public class MemorySetPersonaDao implements IMultipleDao<Persona, String>{

	private Map<String,Persona> mapaPersonas;
	
	public MemorySetPersonaDao(Map<String,Persona> miMapa) {
		super();
		this.mapaPersonas = miMapa;
	}

	@Override
	public void insert(Persona elemento) {
		mapaPersonas.putIfAbsent(elemento.getDni(), elemento);
		
	}

	@Override
	public Persona update(Persona elemento) {
		if(mapaPersonas.replace(elemento.getDni(), elemento) != null) {
			return elemento;
		}
		return null;
	}

	@Override
	public void delete(Persona elemento) {
		mapaPersonas.remove(elemento.getDni());
	}

	@Override
	public Collection<Persona> list() {
		return mapaPersonas.values();
	}

	@Override
	public List<Persona> searchByNames(String name) {
		List<Persona> lista = new ArrayList<Persona>();
		for(Persona persona: mapaPersonas.values()) {
			if(persona.getNombre().equals(name)) {
				lista.add(persona);
			}
		}
		return lista;
	}

	@Override
	public Persona searchById(String id) {
		if(mapaPersonas.containsKey(id)) {
			return mapaPersonas.get(id);
		}
		return null;
	}



}
