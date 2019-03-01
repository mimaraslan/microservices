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
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/employeeDetails/{employeeid}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String getEmployees(@PathVariable int employeeid) {
	
			
		String response = restTemplate
				.exchange("http://localhost:8012/findEmployeeDetails/"+employeeid
			//	.exchange("http://_02_employee-service:8012/findEmployeeDetails/"+employeeid
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, employeeid).getBody();
		
		
		System.out.println("Getting Employee details for " + employeeid);

		System.out.println("Response Body " + response);

		return "Employee Id -  " + employeeid + " [ Employee Details " + response + " ]";
	}

	public String fallbackMethod(int employeeid) {
		return "Fallback response:: No employee details available temporarily "+ employeeid;
	}

}