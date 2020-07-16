package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceMainZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMainZuulApiGatewayApplication.class, args);
	}

}