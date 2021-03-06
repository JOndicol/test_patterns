package com.sopra.spring.ejemplo12ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Ejemplo12ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo12ConfigServerApplication.class, args);
	}

}
