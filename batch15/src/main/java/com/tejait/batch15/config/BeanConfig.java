package com.tejait.batch15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tejait.batch15.serviceimpl.AccountServiceImpl;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfig {

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
	@Bean
	public WebClient webclient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8081")
				.build();
	}
	@Bean
	public AccountServiceImpl accountservice() {

		return new AccountServiceImpl();
	}
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	
}
