package com.tejait.batch15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
@AllArgsConstructor
@RestController
@RequestMapping("webclient")
public class WebClientController {
	
WebClient webClient;

@GetMapping("asynchName")
public String AsynchronusType() {
	String name="Teja IT";
	Mono<String> tagline=webClient.get()
			.uri("/test/tagline")     
			.retrieve()
			.bodyToMono(String.class);        // ASYNCHRONUS -  NON-BLOCKING
	return name.concat(" "+tagline.block());
}

@GetMapping("synchName")
public String SynchronusType() {
	String name="Teja IT";
	String tagline=webClient.get()
			.uri("http://localhost:8081/test/tagline")
			.retrieve()
			.bodyToMono(String.class)
			.block();                        // SYNCHRONUS - BLOCKING
	return name.concat(" "+tagline);
}

}
