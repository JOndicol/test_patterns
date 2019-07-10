package com.sopra.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sopra.model.entities.DrogitaFina;

@Controller
@Scope("request")
public class ControladorDeDrogas {
	
	@Autowired
	private DrogitaFina droga;
	
	@RequestMapping("home")
	public ModelAndView verFormulario() {
		return new ModelAndView("formularioSpringMVC");
	}
	
	@RequestMapping("muestramelo")
	public ModelAndView muestramelo(@RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo, HttpServletRequest request) {
		
		System.out.println(nombre);
		System.out.println(request.getParameter("nombre"));
		
		this.droga.setNombre(nombre);
		this.droga.setTipo(tipo);
		
		ModelAndView modelAndView = new ModelAndView("muestraDroga");
		modelAndView.addObject("droga", this.droga);
		return modelAndView;

	}
}
