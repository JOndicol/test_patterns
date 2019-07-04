package com.sopra.aulas.consola;

import java.util.Arrays;
import java.util.List;

import com.sopra.aulas.bussiness.GestionAulas;
import com.sopra.java.Patterns.model.entities.Aula;

public class Lanzador {
	public static void main(String[] args) {
		GestionAulas gestion = new GestionAulas();
		gestion.crearAula("Kepler", true, true, 16);
		gestion.crearAula("Galileo", true, true, 12);
		List<Aula> aulas = gestion.dameAulas(Arrays.asList("Kepler", "Galileo"));
		System.out.println(aulas);
	}
}
