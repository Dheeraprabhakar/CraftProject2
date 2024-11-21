package com.example.CraftProject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CraftProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(CraftProject2Application.class, args);
	}

}
