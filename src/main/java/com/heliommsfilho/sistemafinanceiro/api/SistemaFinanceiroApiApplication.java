package com.heliommsfilho.sistemafinanceiro.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.heliommsfilho.sistemafinanceiro.api.config.property.SistemaFinanceiroApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(SistemaFinanceiroApiProperty.class)
public class SistemaFinanceiroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaFinanceiroApiApplication.class, args);
	}

}
