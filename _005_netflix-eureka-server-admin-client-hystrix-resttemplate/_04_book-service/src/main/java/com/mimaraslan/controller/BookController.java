package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class BookController {

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	// http://localhost:8084/call
	@RequestMapping(value = "/call")
	public String callServiceClass1() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("myservice", false);
		String url = instanceInfo.getHomePageUrl();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url,  HttpMethod.GET, null, String.class);
		return responseEntity.getBody();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	// http://localhost:8084
	@RequestMapping(value = "/")
	public String callServiceClass() {
		return restTemplate.getForEntity("http://myservice", String.class).getBody();
	}	
}