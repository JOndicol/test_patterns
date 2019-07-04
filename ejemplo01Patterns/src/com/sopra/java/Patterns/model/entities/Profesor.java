package com.sopra.java.Patterns.model.entities;

public class Profesor extends Persona{

	@Override
	public String identificador() {
		return "Profesor: " + this.getNombre() + " " + this.getDni();
	}

}
