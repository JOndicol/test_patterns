package com.sopra.spring.model.dao;

import java.util.List;

import com.sopra.spring.model.entities.Expediente;

public class ExpedienteDao {
	
	private List<Expediente> expedientes;
	
	public Boolean addExpediente(Expediente expediente) {
		return expedientes.add(expediente);
	}
	
	public List<Expediente> listarExpedientes(){
		return expedientes;
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	
	
}
