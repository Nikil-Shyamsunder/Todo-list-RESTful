package com.nikilshyamsunder.todo_restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoSpringApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoSpringApplication.class, args);
		log.info("Application started successfully!");
	}
}
