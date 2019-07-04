package com.sopra.aulas.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.sopra.aulas.dao.IDao;
import com.sopra.aulas.dao.IMultipleDao;
import com.sopra.aulas.dao.MemoryListLogDao;
import com.sopra.aulas.dao.MemoryMapAulaDao;
import com.sopra.aulas.dao.MemorySetPersonaDao;
import com.sopra.java.Patterns.model.entities.Aula;
import com.sopra.java.Patterns.model.entities.LineaDeLog;
import com.sopra.java.Patterns.model.entities.Persona;

public class Factory {
	
	private static IDao<Aula> miAulaDao;
	private static IMultipleDao<LineaDeLog, Integer> miLogDao;
	private static IMultipleDao<Persona, String> miPersonaDao;
	
	public static IDao<Aula> getDaoDeAula(){
		if(miAulaDao == null) {
			miAulaDao = new MemoryMapAulaDao(new HashMap<String, Aula>());
		}
		return miAulaDao;
		
	}
	public static IMultipleDao<LineaDeLog, Integer> getDaoDeLog(){
		if(miLogDao == null) {
			miLogDao= new MemoryListLogDao(new ArrayList<LineaDeLog>());
		}
		return miLogDao;
	}
	
	public static IMultipleDao<Persona, String> getDaoDePersona(){
		if(miPersonaDao == null){
			miPersonaDao = new MemorySetPersonaDao(new HashMap<String, Persona>());
		}
		return miPersonaDao;
	}
	
}
