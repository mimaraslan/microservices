package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RobbinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobbinServerApplication.class, args);
	}
}