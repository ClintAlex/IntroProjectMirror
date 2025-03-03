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
