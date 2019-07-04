package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.Patterns.model.entities.Aula;

public class MemoryListAulaDao implements IDao<Aula>{
	
	private List<Aula> miListaDeAulas;

	public MemoryListAulaDao(List<Aula> miListaDeAulas) {
		super();
		this.miListaDeAulas = miListaDeAulas;
	}

	@Override
	public void insert(Aula aula) {
		
		if(!miListaDeAulas.contains(aula)) {
			miListaDeAulas.add(aula);
		}
		
	}

	@Override
	public Aula update(Aula aula) {
		
		if(miListaDeAulas.contains(aula)) {
			//Podemos poner el remove con aula directamente porque ya tenemos el equals y el hash code, aunque tengan propiedades
			//distintas se deber�a cumplir que tienen el mismo hash ya que tienen el mismo nombreAula.
			miListaDeAulas.add(miListaDeAulas.indexOf(aula), aula);
			return aula;
		}

		return null;
	}

	@Override
	public void delete(Aula aula) {

		miListaDeAulas.remove(aula);
		
	}

	@Override
	public Collection<Aula> list() {
		//Esto no es lo correcto, habria que crear un metodo clone y devolver una copia de miListaDeAulas
		return miListaDeAulas;
	}

	@Override
	public Collection<Aula> search(Aula aula) {	
		Collection<Aula> coleccion = new ArrayList<>();
		if(miListaDeAulas.contains(aula)) {
			coleccion.add(miListaDeAulas.get(miListaDeAulas.indexOf(aula)));		
			return coleccion;
		}
		return coleccion;
	}
	
}
