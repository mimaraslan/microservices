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

import com.mimaraslan.model.MyMicroservice2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyMicroservice2Controller {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	private static final Map<Integer, MyMicroservice2> myMicroervice2Data = new HashMap<Integer, MyMicroservice2>() {

		private static final long serialVersionUID = 1L;{
			put(1, new MyMicroservice2(1, "myMicroervice2-Object1"));
			put(2, new MyMicroservice2(2, "myMicroervice2-Object2"));
		}
	};
	
	
	// http://localhost:9001/service2/1
	@HystrixCommand
	@GetMapping(value = "/service2/{myTestId}")
	public MyMicroservice2 getMyMicroervice1Details(@PathVariable int myTestId) {

		MyMicroservice2 myMicroervice1 = myMicroervice2Data.get(myTestId);
		if (myMicroervice1 == null) {
			myMicroervice1 = new MyMicroservice2(0, "N/A");
		}
		System.out.println("Getting MyMicroservice2 details for " + myTestId);
		return myMicroervice1;
	}
	
	
	// http://localhost:9002/service2toService1/1
	@HystrixCommand(fallbackMethod = "fallbackMethodForService2")
	@RequestMapping(value = "/service2toService1/{myTestId}", method = RequestMethod.GET)
	public String getFromService2toService1Info(@PathVariable int myTestId) {
	
		String response = restTemplate
				.exchange("http://service-a1/service1/"+myTestId
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, myTestId).getBody();
		
		
		System.out.println("Getting MyMicroservice1 details for " + myTestId);

		System.out.println("Response Body " + response);

		return "Service2 to Service1 _ Id: " + myTestId + " [ MyMicroservice1 Details " + response + " ]";
	}

	public String fallbackMethodForService2(int myTestId) {
		return "Fallback response:: No MyMicroservice1 details available temporarily :"+ myTestId;
	}

}