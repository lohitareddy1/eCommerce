package com.project.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class EcommerceApplication {

	public static final String API_eCom = "/api/v1/";
	public static void main(String[] args) {

	    SpringApplication.run(EcommerceApplication.class, args);
	}
}
