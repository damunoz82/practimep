package com.karinasoft.practimep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.karinasoft.practimep.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class PractiMepApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiMepApplication.class, args);
	}
	
}
