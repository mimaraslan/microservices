package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookController {

	@Autowired
	private RestTemplate template;

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	// http://localhost:8084/bookNow1
	@HystrixCommand(groupKey = "myKey1", commandKey = "myKey1", fallbackMethod = "myShowFallBack")
	@GetMapping("/bookNow1")
	public String bookShow1() throws InterruptedException {
	
		String emailServiceResponse = template.getForObject("http://localhost:8082/email/send", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8083/payment/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	// http://localhost:8084/bookNow2
	@HystrixCommand(groupKey = "myKey2", commandKey = "myKey2", fallbackMethod = "myShowFallBack")
	@GetMapping("/bookNow2")
	public String bookShow2() throws InterruptedException {
		Thread.sleep(3000);
		String emailServiceResponse = template.getForObject("http://localhost:8082/email/send", String.class);
		String paymentServiceResponse = template.getForObject("http://localhost:8083/payment/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}

	public String myShowFallBack() {
		return "service gateway failed...";
	}
}