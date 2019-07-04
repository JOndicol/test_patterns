package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.Patterns.model.entities.LineaDeLog;

public class MemoryListLogDao implements IMultipleDao<LineaDeLog, Integer>{

	private List<LineaDeLog> miListaDeLogs;
	
	public MemoryListLogDao(List<LineaDeLog> miListaDeLogs) {
		super();
		this.miListaDeLogs = miListaDeLogs;
	}
	@Override
	public void insert(LineaDeLog elemento) {
		if(!miListaDeLogs.contains(elemento)) {
			miListaDeLogs.add(elemento);
		}
	}

	@Override
	public LineaDeLog update(LineaDeLog elemento) {
		if(miListaDeLogs.contains(elemento)) {
			//Podemos poner el remove con aula directamente porque ya tenemos el equals y el hash code, aunque tengan propiedades
			//distintas se deber�a cumplir que tienen el mismo hash ya que tienen el mismo nombreAula
			miListaDeLogs.add(miListaDeLogs.indexOf(elemento), elemento);
			return elemento;
		}

		return null;
	}

	@Override
	public void delete(LineaDeLog elemento) {
		miListaDeLogs.remove(elemento);
		
	}

	@Override
	public Collection<LineaDeLog> list() {
		//Esto no es lo correcto, habria que crear un metodo clone y devolver una copia de miListaDeAulas
		return miListaDeLogs;
	}
	@Override
	public List<LineaDeLog> searchByNames(String name) {
		List<LineaDeLog> listaDeLogs = new ArrayList<>();
		for(LineaDeLog lineaActual: miListaDeLogs) {
			if(lineaActual.getNombre().equals(name)) {
				listaDeLogs.add(lineaActual);
			}
		}
		return listaDeLogs;
	}
	@Override
	public LineaDeLog searchById(Integer id) {
		LineaDeLog log = null;
		for(int i = 0; i < miListaDeLogs.size() || log == null;i++) {
			if(miListaDeLogs.get(i).getId().equals(id)) {
				return miListaDeLogs.get(i);
			}
		}
		return null;
	}
	


}
