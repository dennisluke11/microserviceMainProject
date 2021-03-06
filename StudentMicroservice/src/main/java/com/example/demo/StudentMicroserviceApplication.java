package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example")
//@EntityScan("com.example.demo.demo")
//@EnableJpaRepositories(basePackages = "com.example.demo.StudentRepository")
public class StudentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	WebClient.Builder webClientBuilder(){
		return WebClient.builder();
	}

}
