package com.internship.introproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//test
@SpringBootApplication
public class IntroprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroprojectApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
//Prøv at sætte alt dette op og sørg for at det snakker sammen:
//
//Git
//Spring Boot
//Postgres
//image: postgres:latest
//containername: PostgresContainer
//ports: host: 5433, containerport: 5432
//POSTGRES_DB: db1
//POSTGRES_PASSWORD: 5454
//POSTGRES_USER: postuser
//localhost 5433 postuser 5454 db1
//Docker Desktop
//Postman
//
//Test case:
//JSONPlaceholder https://jsonplaceholder.typicode.com/
//
//gem /posts ned i postgres som kører i Docker ved hjælp af Spring