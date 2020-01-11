package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	// http://localhost:8083
	@RequestMapping("/")
	public String HelloWorld() {
		return "My Service 2";
	}
	
	// http://localhost:8083/payment/pay
	@GetMapping("/payment/pay")
	public String paymentProcess() {
		return "Payment service called....";
	}
}