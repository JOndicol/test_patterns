package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.sopra.java.Patterns.model.entities.Aula;

public class MemorySetAulaDao implements IDao<Aula>{

	private Set<Aula> miSet;
	
	public MemorySetAulaDao(Set<Aula> miSet) {
		super();
		this.miSet = miSet;
	}

	@Override
	public void insert(Aula aula) {
		miSet.add(aula);
	}

	@Override
	public Aula update(Aula aula) {
		if(miSet.contains(aula)) {
			//Podemos poner el remove con aula directamente porque ya tenemos el equals y el hash code, aunque tengan propiedades
			//distintas se deber�a cumplir que tienen el mismo hash ya que tienen el mismo nombreAula.
			miSet.remove(aula);
			miSet.add(aula);
			return aula;
		}

		return null;
	}

	@Override
	public void delete(Aula aula) {
		miSet.remove(aula);
	}

	@Override
	public Collection<Aula> list() {
		return miSet;
	}

	@Override
	public Collection<Aula> search(Aula aula) {
		Collection<Aula> coleccion = new ArrayList<>();
		if(miSet.contains(aula)) {
			for(Aula aulaActual: miSet) {
				if(aulaActual.equals(aula)) {
					coleccion.add(aulaActual);
					return coleccion;
				}
			}	
		}
		return coleccion;
	}

}
