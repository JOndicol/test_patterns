package com.sopra.spring.ejemplo02spring.ej02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador02 {
	
	public static void main(String[] args) {
		ApplicationContext context  = new ClassPathXmlApplicationContext("ej02.xml");
		List<Chorizo> listadeChorizos = context.getBean("miLista", List.class);
		for(int i = 0; i < 10; i++) {
			listadeChorizos.add(context.getBean("chorizo", Chorizo.class));
		}
		System.out.println(listadeChorizos);
		listadeChorizos.get(3).setMarca("Ezequiel");
		System.out.println(listadeChorizos);
		((ClassPathXmlApplicationContext)context).close();
	}

}
