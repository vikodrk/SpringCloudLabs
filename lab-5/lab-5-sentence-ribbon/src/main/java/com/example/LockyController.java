package com.example;

import java.net.URI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LockyController {
	
	private static final Logger LOGGER = Logger.getLogger(LockyController.class);

	@Value("${info}") String info;
	
	@Autowired
	LoadBalancerClient client;

	@RequestMapping("/sentence")
	public @ResponseBody String showLuckyWord() {
		StringBuilder builder = new StringBuilder();
		builder.append(getWord("LAB-4-CLIENT")).append(" ");
		builder.append(getWord("LAB-4-VERB")).append(" ");
		builder.append(getWord("LAB-4-ARTICLE")).append(" ");
		builder.append(getWord("LAB-4-ADJECTIVE")).append(" ");
		builder.append(getWord("LAB-4-NOUN")).append(" ");
		return builder.toString();
	}
	
	@RequestMapping("/info")
	public @ResponseBody String showServerInfo(){
		return info;
	}

	private String getWord(String service) {
		LOGGER.info("Load Balancer CLient >>>>>>>>"+client);
		ServiceInstance serviceInstance = client.choose(service);
		LOGGER.info("Service Instance>>>>>>"+serviceInstance);
		if (serviceInstance != null ) {
			URI uri = serviceInstance.getUri();
			LOGGER.info("URI>>>>>>>>>>>>>>"+uri.toString());
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return service;
	}

}
