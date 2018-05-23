package com.parqueadero2.gradle3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan({"com.parqueadero2.gradle3", "com.parqueadero2.servicios"})
@EnableAutoConfiguration
@EnableJpaRepositories({"com.parqueadero2.repository"})
public class ParqueaderoBoot {

	public static void main(String[] args) {
		SpringApplication.run(ParqueaderoBoot.class, args);

	}

}
