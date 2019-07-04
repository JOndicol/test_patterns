package com.sopra.aulas.bussiness;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sopra.java.Patterns.model.entities.Alumno;
import com.sopra.java.Patterns.model.entities.Aula;
import com.sopra.java.Patterns.model.entities.Profesor;
import com.sopra.java.Patterns.model.entities.Puesto;

public class GestionCursos {
	
	//TODO: Los TODOS salen en markers
	private GestionAulas gestorAulas;
	private GestionPersonas gestionPersonas;
	private GestionDeLog gestionLog;
	
	
	public GestionCursos() {
		gestorAulas = new GestionAulas();
		gestionLog = new GestionDeLog();
		gestionPersonas = new GestionPersonas();
	}
	
	public void crearCurso (
			String nombre, Boolean proyector, Boolean pizarra, Map<String,String> alumnos,
			String nombreProfesor, String dniProfesor) throws Exception {
		
		gestorAulas.crearAula(nombre, proyector, pizarra, alumnos.size());
		gestionPersonas.crearProfesor(nombreProfesor, dniProfesor);
		Collection<Alumno> alumnosGuardados = almacenarAlumnosDesdeElGestor(alumnos);
		
		List<Aula> aulas = gestorAulas.dameAulas(Arrays.asList(nombre));
		if(aulas.size() == 1) {
			Aula aula = aulas.get(0);
			
			Iterator<Alumno> recorreAlmunos = alumnosGuardados.iterator();
			Iterator<Puesto> recorrePuestos = aula.getLista_alumnos().iterator();
			while(recorreAlmunos.hasNext() && recorrePuestos.hasNext()) {
				Puesto puesto = recorrePuestos.next();
				puesto.setPersona(recorreAlmunos.next());
			}
			
			Set<Profesor> listaProfesores = gestionPersonas.listarProfesores();
			Profesor profesorQueBusco = new Profesor();
			profesorQueBusco.setDni(dniProfesor);
			
			for(Profesor profesorEncontrado: listaProfesores) {
				if(profesorEncontrado.equals(profesorQueBusco)) {
					aula.getPuesto_profesor().setPersona(profesorEncontrado);
				}
			}
			
		}else {
			throw new Exception("No existe el aula");
		}
	}

	private Collection<Alumno> almacenarAlumnosDesdeElGestor(Map<String, String> alumnos) {
		
		for(String dni: alumnos.keySet()) {
			gestionPersonas.crearAlumno(alumnos.get(dni),dni);
		}
		
		Collection<Alumno> alumnosEncontrados = new HashSet<Alumno>();
		Set<Alumno> listaAlumnos = gestionPersonas.listarAlumnos();
		
		for(Alumno alumno: listaAlumnos) {
			if(alumnos.containsKey(alumno.getDni())) {
				alumnosEncontrados.add(alumno);
			}
		}
		
		return alumnosEncontrados;
	}

}
