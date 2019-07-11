package com.sopra.spring.ejemplo10RestJpa.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.spring.ejemplo10RestJpa.model.entities.Arma;

public interface AlmacenDeArmas extends JpaRepository<Arma, Integer>{

}
