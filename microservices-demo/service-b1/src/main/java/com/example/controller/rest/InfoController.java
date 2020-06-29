package com.example.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RequestMapping
@RestController
public class InfoController {
	

	@Value("${app.id}")
	String instance;
	
	@Value("${server.port}")
	String port;
	
	@Value("${config.server.service-b1-key}")
	private String propertyKey;
	
	// http://localhost:9002/info/propertykey
	@GetMapping("/propertykey")
	public String fetchProperty() {
		return propertyKey;
	}
	
	// http://localhost:9002/hello
	// http://localhost:9002/info
	@GetMapping({"/hello", "info"})
	public String sayHello(){
		return instance + " :  service-b1 : " + port;
	}
}