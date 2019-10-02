package com.mimaraslan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.mimaraslan.config.RibbonConfiguration;

@SpringBootApplication
@RibbonClient(name = "ribbon-server", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}