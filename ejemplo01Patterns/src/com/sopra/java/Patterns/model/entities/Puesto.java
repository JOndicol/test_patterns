package com.sopra.java.Patterns.model.entities;

public class Puesto {
	
	private Boolean ordenador;
	private Persona persona;
	
	
	public Boolean getOrdenador() {
		return ordenador;
	}


	public void setOrdenador(Boolean ordenador) {
		this.ordenador = ordenador;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Puesto() {
		super();
	}
}
