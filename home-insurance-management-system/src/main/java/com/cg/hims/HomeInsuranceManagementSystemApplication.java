package com.cg.hims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class HomeInsuranceManagementSystemApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(HomeInsuranceManagementSystemApplication.class, args);
		System.out.println("connected to database");
	}

	@Bean
	public Docket hmisApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cg.hims")).build();
	}
}
