package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	// http://localhost:8082
	@RequestMapping("/")
	public String HelloWorld() {
		return "My Service 1";
	}

	// http://localhost:8082/email/send
	@GetMapping("/email/send")
	public String sendEmail() {
		return "Email service called....";
	}
}