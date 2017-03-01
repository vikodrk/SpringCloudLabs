package com.example.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rest.ws.consumer.INounRESTService;
import com.example.services.INounService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class NounService implements INounService{
	
	@Autowired
	INounRESTService adjectiveRestConsumer;

	@Override
	public String getWord() {
		return adjectiveRestConsumer.getWord();
	}
	
	@HystrixCommand(fallbackMethod="getWord")
	public String getWordFallback(){
		return "Error con la aplicacion LAB-4-ADJECTIVE";
	}

}
