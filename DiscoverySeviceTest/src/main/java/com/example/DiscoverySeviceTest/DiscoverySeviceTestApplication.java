package com.example.DiscoverySeviceTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoverySeviceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoverySeviceTestApplication.class, args);
	}

}
