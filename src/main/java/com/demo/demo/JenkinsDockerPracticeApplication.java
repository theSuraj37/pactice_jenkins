package com.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JenkinsDockerPracticeApplication {

	@GetMapping
	public String message() { return "welcome to Suraj's jenkins"; };

	public static void main(String[] args) {
		SpringApplication.run(JenkinsDockerPracticeApplication.class, args);
	}

}
