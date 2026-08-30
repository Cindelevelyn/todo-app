package com.cindel.todoapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodoapiApplication {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/to-dos")
	public List<String> toDos() {
		return List.of("tarefa 1", "tarefa 2");
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoapiApplication.class, args);
	}

}
