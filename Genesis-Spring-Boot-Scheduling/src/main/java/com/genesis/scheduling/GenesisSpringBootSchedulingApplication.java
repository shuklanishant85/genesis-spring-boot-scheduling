package com.genesis.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author nisshukl0
 *
 * @EnableScheduling ensures that a background task executor is created. Without
 *                   it, nothing gets scheduled. @Scheduled annotation is used
 *                   to run a method on scheduled basis.
 */
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@EnableWebMvc
public class GenesisSpringBootSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenesisSpringBootSchedulingApplication.class, args);
	}

}
