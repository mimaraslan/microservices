package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobbinServerController {

	@Autowired
	Environment environment;

	@GetMapping("/")
	public String health() {
		return "Robbin Server";
	}

	@GetMapping("/backend")
	public String backend() {
		String serverPort = environment.getProperty("local.server.port");
		System.out.println("Robbin Server::backend..., Port : " + serverPort);
		return "Hello form Backend! Host : localhost, Port : " + serverPort;
	}
}