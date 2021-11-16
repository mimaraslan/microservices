package com.mimaraslan;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableAdminServer
@EnableEurekaServer
@SpringBootApplication
public class MainServiceSpringCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainServiceSpringCloudEurekaServerApplication.class, args);
    }

}