package com.sopra.spring.ejemplo02spring.ej01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanzadorConSpring {

	private static ApplicationContext context  = new ClassPathXmlApplicationContext("ej01.xml");
	
	public static void main(String[] args) {
	
		BarDeCopas elPersi = context.getBean("elPersi", BarDeCopas.class);
		System.out.println(elPersi);
		elPersi.setCalidadDeLaBebida("sigue siendo una mierda");
		cambiaCalidad();
		System.out.println(elPersi);
	}
	
	private static void cambiaCalidad() {
		BarDeCopas elPersi = context.getBean("elPersi", BarDeCopas.class);
		System.out.println(elPersi);
		elPersi.setCalidadDeLaBebida("Don Rodrigo Fans");
	}

}
