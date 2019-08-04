package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class SchoolController {
	
	@Autowired
	RestTemplate restTemplate;
	
    // http://localhost:8082/api/v1/school/A
    // http://localhost:8082/api/v1/school/B
	@RequestMapping(value = "/school/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {

		System.out.println("Getting School details for " + schoolname);
		
		//student
		String response = restTemplate.exchange("http://student-service/api/v2/student/{schoolname}",
	    HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();

		System.out.println("Response Received as " + response);

		return "School Name -  " + schoolname + " \n Student Details " + response;
	}
	
	

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
