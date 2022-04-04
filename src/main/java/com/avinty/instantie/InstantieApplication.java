package com.avinty.instantie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class InstantieApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstantieApplication.class, args);
	}

}
