package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LombokJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokJpaApplication.class, args);
	}

}
