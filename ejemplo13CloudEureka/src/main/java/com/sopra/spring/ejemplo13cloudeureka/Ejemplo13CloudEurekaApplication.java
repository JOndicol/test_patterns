package com.sopra.spring.ejemplo13cloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Ejemplo13CloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo13CloudEurekaApplication.class, args);
	}

}
