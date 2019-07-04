package com.sopra.aulas.bussiness;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sopra.aulas.dao.Factory;
import com.sopra.aulas.dao.IMultipleDao;
import com.sopra.java.Patterns.model.entities.Alumno;
import com.sopra.java.Patterns.model.entities.LineaDeLog;
import com.sopra.java.Patterns.model.entities.Nivel;
import com.sopra.java.Patterns.model.entities.Persona;
import com.sopra.java.Patterns.model.entities.Profesor;

public class GestionPersonas {
	
	private IMultipleDao<Persona, String> miDaoDePersona;
	private IMultipleDao<LineaDeLog, Integer> miDaoDeLogs;
	
	public GestionPersonas() {
		this.miDaoDeLogs = Factory.getDaoDeLog();
		this.miDaoDePersona = Factory.getDaoDePersona();
	}
	
	public Persona crearAlumno(String nombre, String dni) {
		Persona alumno = new Alumno();
		alumno.setNombre(nombre);
		alumno.setDni(dni);
		miDaoDePersona.insert(alumno);
		miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Alumno agregado", miDaoDePersona.getClass().toString(),  new Date()));	
		return alumno;
	}
	public Persona crearProfesor(String nombre, String dni) {
		Persona profesor = new Profesor();
		profesor.setNombre(nombre);
		profesor.setDni(dni);
		miDaoDePersona.insert(profesor);
		miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Profesor agregado",miDaoDePersona.getClass().toString(),  new Date()));
		return profesor;
	}
	
	public Set<Persona> listarPersonas(){
		return new HashSet<Persona>(miDaoDePersona.list());
	}
	
	public Set<Alumno> listarAlumnos(){
		Set<Alumno> alumnos = new HashSet<Alumno>();
		for(Persona persona: miDaoDePersona.list()) {
			if(persona instanceof Alumno) {
				Alumno alumno = (Alumno) persona;
				alumnos.add(alumno);
			}
		}
		return alumnos;
	}
	
	public Set<Profesor> listarProfesores(){
		Set<Profesor> profesores = new HashSet<Profesor>();
		for(Persona persona: miDaoDePersona.list()) {
			if(persona instanceof Profesor) {
				Profesor profesor = (Profesor) persona;
				profesores.add(profesor);
			}
		}
		return profesores;
	}
}
