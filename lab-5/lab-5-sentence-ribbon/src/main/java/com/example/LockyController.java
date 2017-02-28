package com.example;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LockyController {

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

	private String getWord(String service) {
		ServiceInstance serviceInstance = client.choose(service);
		if (serviceInstance != null ) {
			URI uri = serviceInstance.getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}

}
