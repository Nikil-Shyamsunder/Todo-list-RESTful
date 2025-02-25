package com.nikilshyamsunder.learn_spring;

import com.nikilshyamsunder.learn_spring.run.Location;
import com.nikilshyamsunder.learn_spring.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class LearnSpringApplication {

	private static final Logger log = LoggerFactory.getLogger(LearnSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
		log.info("Application started successfully!");
	}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Run run = new Run(1, "first run", LocalDateTime.now(),
					LocalDateTime.now().plusHours(1), 3, Location.INDOOR);
			log.info(run.toString());
		};
	}
}
