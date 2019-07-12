package com.sopra.spring.ejemplo14cloudConfigClientClone.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiPrimerRestController {
	
	@Value("${mensaje: Hola caracola}")
	private String mensaje;

	@RequestMapping("/")
	public String saludar() {
		return mensaje;
	}
}
