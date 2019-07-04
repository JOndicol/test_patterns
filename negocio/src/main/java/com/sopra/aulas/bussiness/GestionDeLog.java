package com.sopra.aulas.bussiness;

import java.util.ArrayList;
import java.util.List;

import com.sopra.aulas.dao.Factory;
import com.sopra.aulas.dao.IMultipleDao;
import com.sopra.java.Patterns.model.entities.LineaDeLog;

public class GestionDeLog {
	
	private IMultipleDao<LineaDeLog, Integer> miDaoDeLogs;
	
	public GestionDeLog(){
		miDaoDeLogs = Factory.getDaoDeLog();
	}
	
	public List<LineaDeLog> getLog(){
		return new ArrayList<LineaDeLog>(miDaoDeLogs.list());
	}
}
