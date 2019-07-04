package com.sopra.java.Patterns.model.entities;

public class Alumno extends Persona{

	@Override
	public String identificador() {
		return "Alumno: " + this.getNombre() + " " + this.getDni();
	}

}
