package com.iib.gov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootMs4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMs4Application.class, args);
	}

}
