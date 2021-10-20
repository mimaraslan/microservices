package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestResource {

	// http://localhost:8888
	@RequestMapping
	public String sayHello() {
		return "Hi, from service-main-cloud-remote-config-server!";
	}

	// http://localhost:8888/message
	@RequestMapping(value = "/message")
	public String getMessage() {
		return "Hi, from Spring Cloud! - getMessage ";
	}

}