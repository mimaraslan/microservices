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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CompanyController {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/employeeDetails/{empId}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String getEmployees(@PathVariable int empId) {
	
			
		String response = restTemplate
				.exchange("http://employeeservice/findEmployeeDetails/"+empId
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, empId).getBody();
		
		
		System.out.println("Getting Employee details for " + empId);

		System.out.println("Response Body " + response);

		return "Employee Id -  " + empId + " [ Employee Details " + response + " ]";
	}

	public String fallbackMethod(int employeeid) {
		return "Fallback response:: No employee details available temporarily "+ employeeid;
	}

}