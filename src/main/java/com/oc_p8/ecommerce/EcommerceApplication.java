package com.oc_p8.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.DecoratorDemo;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

		// Decorator Demo
		new DecoratorDemo().run();
	}

}
