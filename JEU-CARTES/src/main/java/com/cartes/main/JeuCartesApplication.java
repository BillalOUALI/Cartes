package com.cartes.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class JeuCartesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		log.info("Initialisation de l'application");
		SpringApplication.run(JeuCartesApplication.class, args);
	}

}
