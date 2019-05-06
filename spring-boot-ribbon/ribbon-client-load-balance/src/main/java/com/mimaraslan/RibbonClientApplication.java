package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.mimaraslan.config.RibbonConfiguration;

@RibbonClient(name = "ribbon-client-load-balance", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
