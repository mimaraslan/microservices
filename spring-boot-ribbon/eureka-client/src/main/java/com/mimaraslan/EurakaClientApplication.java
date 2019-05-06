package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EurakaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurakaClientApplication.class, args);
	}
}
