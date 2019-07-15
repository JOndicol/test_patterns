package com.sopra.spring.ejemplo10RestJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ejemplo10RestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo10RestJpaApplication.class, args);
	}

}
