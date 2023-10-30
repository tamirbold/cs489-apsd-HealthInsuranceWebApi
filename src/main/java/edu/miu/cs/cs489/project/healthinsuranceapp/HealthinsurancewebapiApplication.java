package edu.miu.cs.cs489.project.healthinsuranceapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthinsurancewebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthinsurancewebapiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (){
		return (args) -> {
			System.out.println("hello webapi");
		};
	}
}
