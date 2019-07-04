package com.sopra.aulas.bussiness;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.sopra.aulas.dao.Factory;
import com.sopra.aulas.dao.IDao;
import com.sopra.aulas.dao.IMultipleDao;
import com.sopra.java.Patterns.model.entities.Aula;
import com.sopra.java.Patterns.model.entities.LineaDeLog;
import com.sopra.java.Patterns.model.entities.Nivel;
import com.sopra.java.Patterns.model.entities.Puesto;

public class GestionAulas {
	
	private IDao<Aula> miDaoDeAulas;
	private IMultipleDao<LineaDeLog, Integer> miDaoDeLogs;
	
	public GestionAulas() {
		this.miDaoDeLogs = Factory.getDaoDeLog();
		this.miDaoDeAulas = Factory.getDaoDeAula();
	}
	
	public Aula crearAula(String nombre, Boolean proyector, Boolean pizarra, Integer alumnos) {
		Aula aula = new Aula();
		aula.setNombreAula(nombre);
		aula.setPizarra(pizarra);
		aula.setProyector(proyector);
		Collection<Puesto> puestosDeAlumnos = new HashSet<>();
		
		for(int i = 0; i< alumnos; i++) {
			puestosDeAlumnos.add(new Puesto());
		} 
		
		aula.setPuesto_profesor(new Puesto());
		aula.setLista_alumnos(puestosDeAlumnos);
		miDaoDeAulas.insert(aula);
		miDaoDeLogs.insert(new LineaDeLog(Nivel.INFO, "Aula agregada", miDaoDeAulas.getClass().toString(),  new Date()));
		return aula;		
	}
	public List<Aula> dameAulas(List<String> nombreDeAulas){
		List<Aula> listaDeAulas = new ArrayList<>();
		for(String nombre: nombreDeAulas) {
			Aula aulaABuscar = new Aula();
			aulaABuscar.setNombreAula(nombre);
			Collection<Aula> aulaEncontrada = miDaoDeAulas.search(aulaABuscar);
			if(aulaEncontrada != null) {
				listaDeAulas.addAll(aulaEncontrada);
			}
		}
		
		return listaDeAulas;
	}
}
