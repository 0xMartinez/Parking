package com.project.Parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);


	}
	@Bean
	public Docket get_1(){
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.groupName("Add")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.Parking.controller"))
				.build()
				.apiInfo(apiInfo());
		return docket;
	}


	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Parking Project",
				"Api for My Project",
				"v1.1",
				"https://github.com/msperski/Parking",
				new Contact("Marcin", "https://github.com/msperski/Parking", "NA"),
						"My own licence",
						"https://github.com/msperski/Parking",
				Collections.emptyList());
	}
}
