package com.example.config;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class Lab5SentenceRibbonConfig {
	
	@Bean
	public IPing ribbongPing(IClientConfig config){
		return new PingUrl();
	}
	
	@Bean
	public IRule ribbonRule(IClientConfig config){
		return new AvailabilityFilteringRule();
	}

}
