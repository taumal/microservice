package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAgwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAgwApplication.class, args);
	}

}
