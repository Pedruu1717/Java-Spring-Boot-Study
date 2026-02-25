package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ui.Model;

import java.util.Arrays;

@SpringBootApplication
public class BraguiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BraguiaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Estes são os beans fornecidos pelo Spring Boot:");

			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean : beans) {
				System.out.println(bean);
			}
		};
	}
}
