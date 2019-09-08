package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

	// http://localhost:8082/email/send
	@GetMapping("/send")
	public String sendEmail() {
		return "Email service called....";
	}
}