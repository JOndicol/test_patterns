package com.sopra.java.Patterns.model.entities;

import java.util.Collection;

public class Aula {
	
	private Boolean proyector;
	private Boolean pizarra;
	private Puesto puesto_profesor;
	private Collection<Puesto> puestosAlumnos;
	private String nombreAula;
	
	public String getNombreAula() {
		return nombreAula;
	}

	public void setNombreAula(String nombreAula) {
		this.nombreAula = nombreAula;
	}

	public Boolean getProyector() {
		return proyector;
	}

	public void setProyector(Boolean proyector) {
		this.proyector = proyector;
	}

	public Boolean getPizarra() {
		return pizarra;
	}

	public void setPizarra(Boolean pizarra) {
		this.pizarra = pizarra;
	}

	public Puesto getPuesto_profesor() {
		return puesto_profesor;
	}

	public void setPuesto_profesor(Puesto puesto_profesor) {
		this.puesto_profesor = puesto_profesor;
	}

	public Collection<Puesto> getLista_alumnos() {
		return puestosAlumnos;
	}

	public void setLista_alumnos(Collection<Puesto> lista_alumnos) {
		this.puestosAlumnos = lista_alumnos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreAula == null) ? 0 : nombreAula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (nombreAula == null) {
			if (other.nombreAula != null)
				return false;
		} else if (!nombreAula.equals(other.nombreAula))
			return false;
		return true;
	}

	public Aula() {
		super();
	}
}
