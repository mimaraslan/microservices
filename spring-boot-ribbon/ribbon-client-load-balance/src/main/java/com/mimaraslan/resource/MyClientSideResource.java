package com.mimaraslan.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClientSideResource {
	
	@Autowired
	RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/ribbon-client-load-balance/frontend")
	public String hi() {
		String randomString = this.restTemplate.getForObject("http://eureka-client/backend", String.class);
		return "Eureka Client Response :: " + randomString;
	}
}