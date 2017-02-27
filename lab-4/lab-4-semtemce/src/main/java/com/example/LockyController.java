package com.example;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LockyController {

	@Autowired
	DiscoveryClient client;

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
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && !list.isEmpty()) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}

}
