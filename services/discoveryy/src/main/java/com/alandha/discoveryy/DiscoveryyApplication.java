package com.alandha.discoveryy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryyApplication.class, args);
    }

}
