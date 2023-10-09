package com.iib.gov.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	 //creating template builder bean
	 @Bean
	 @LoadBalanced
	 public RestTemplate createBean() {
		return new RestTemplateBuilder().basicAuthentication("testadmin","iibadmin@123").build();
		 
		 
	 }


}
