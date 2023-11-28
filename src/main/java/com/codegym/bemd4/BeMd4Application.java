package com.codegym.bemd4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication @EnableWebSecurity
public class BeMd4Application {

	public static void main(String[] args) {
		SpringApplication.run(BeMd4Application.class, args);
	}

}
