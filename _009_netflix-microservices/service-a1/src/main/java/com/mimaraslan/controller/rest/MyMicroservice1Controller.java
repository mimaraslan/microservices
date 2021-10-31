package com.mimaraslan.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mimaraslan.model.MyMicroservice1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyMicroservice1Controller {
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	private static final Map<Integer, MyMicroservice1> myMicroervice1Data = new HashMap<Integer, MyMicroservice1>() {

		private static final long serialVersionUID = 1L;{
			put(1, new MyMicroservice1(1, "myMicroervice1-Object1"));
			put(2, new MyMicroservice1(2, "myMicroervice1-Object2"));
		}
	};

	
	// http://localhost:9001/service1/1
	@HystrixCommand
	@GetMapping(value = "/service1/{myTestId}")
	public MyMicroservice1 getMyMicroervice1Details(@PathVariable int myTestId) {

		MyMicroservice1 myMicroervice1 = myMicroervice1Data.get(myTestId);
		if (myMicroervice1 == null) {
			myMicroervice1 = new MyMicroservice1(0, "N/A");
		}
		System.out.println("Getting MyMicroervice1 details for " + myTestId);
		return myMicroervice1;
	}
	
	
	
	// http://localhost:9001/service1toService2/1
	@HystrixCommand(fallbackMethod = "fallbackMethodForService1")
	@RequestMapping(value = "/service1toService2/{myTestId}", method = RequestMethod.GET)
	public String getFromService1toService2Info(@PathVariable int myTestId) {
	
		String response = restTemplate
				.exchange("http://service-b1/service2/"+myTestId
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, myTestId).getBody();
		
		
		System.out.println("Getting MyMicroservice2 details for " + myTestId);

		System.out.println("Response Body " + response);

		return "Service1 to Service2 _ Id: " + myTestId + " [ MyMicroservice2 Details " + response + " ]";
	}

	public String fallbackMethodForService1(int myTestId) {
		return "Fallback response:: No MyMicroservice2 details available temporarily :"+ myTestId;
	}
	
	
}