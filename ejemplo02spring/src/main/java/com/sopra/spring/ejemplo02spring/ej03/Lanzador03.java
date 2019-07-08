package com.sopra.spring.ejemplo02spring.ej03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador03 {

	public static void main(String[] args) {
		ApplicationContext context  = new ClassPathXmlApplicationContext("ej03.xml");
		
		Cubata cerveza = context.getBean("cubataDeCerveza", Cubata.class);
		Cubata vinate = context.getBean("copaDeVino", Cubata.class);
		Cubata miPinta = context.getBean("miPinta", Cubata.class);
		
		System.out.println(cerveza);
		System.out.println(vinate);
		System.out.println(miPinta);
		
		Licor licor = context.getBean("vinate", Licor.class);
		miPinta.setLicor(licor);
		System.out.println(miPinta);
		
		Cubata miPintaSingleton = context.getBean("miPinta", Cubata.class);
		System.out.println(miPintaSingleton);
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
