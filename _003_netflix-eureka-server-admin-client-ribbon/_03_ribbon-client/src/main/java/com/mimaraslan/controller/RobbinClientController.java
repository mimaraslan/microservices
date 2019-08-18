package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RobbinClientController {
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String health() {
		return "Robbin Client";
	}

	@GetMapping("/frontend")
	public String frontend() {
		String randomString = this.restTemplate.getForObject("http://robbinserver/backend", String.class);
		return "Robbin Server Response :: " + randomString;
	}
}