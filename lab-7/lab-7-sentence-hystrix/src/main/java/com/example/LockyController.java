package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.IAdjectiveService;
import com.example.services.IArticleService;
import com.example.services.IClientService;
import com.example.services.INounService;
import com.example.services.IVerbService;

@RestController
public class LockyController {

	@Value("${info}")
	String info;

	@Autowired
	LoadBalancerClient client;
	
	@Autowired
	IAdjectiveService adjectiveService;
	
	@Autowired
	IArticleService articleService;
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	INounService nounService;
	
	@Autowired
	IVerbService verbService;

	@RequestMapping("/sentence")
	public @ResponseBody String showLuckyWord() {
		StringBuilder builder = new StringBuilder();
		builder.append(clientService.getWord()).append(" ");
		builder.append(verbService.getWord()).append(" ");
		builder.append(articleService.getWord()).append(" ");
		builder.append(adjectiveService.getWord()).append(" ");
		builder.append(nounService.getWord()).append(" * =3 *");
		return builder.toString();
	}

	@RequestMapping("/info")
	public @ResponseBody String showServerInfo() {
		return info;
	}
}
