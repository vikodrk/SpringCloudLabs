package com.example.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rest.ws.consumer.IAdjectiveRESTService;
import com.example.services.IAdjectiveService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class AdjectiveService implements IAdjectiveService{
	
	@Autowired
	IAdjectiveRESTService adjectiveRestConsumer;

	@Override
	@HystrixCommand(fallbackMethod="getWordFallback")
	public String getWord() {
		return adjectiveRestConsumer.getWord();
	}
	
	public String getWordFallback(){
		return "Error con la aplicacion LAB-4-ADJECTIVE";
	}

}
