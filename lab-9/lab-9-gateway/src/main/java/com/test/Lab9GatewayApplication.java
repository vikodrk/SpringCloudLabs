package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableAutoConfiguration
@ComponentScan
public class Lab9GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab9GatewayApplication.class, args);
	}
}
