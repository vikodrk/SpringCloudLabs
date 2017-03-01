package com.example.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rest.ws.consumer.IClientRESTService;
import com.example.services.IClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class ClientService implements IClientService{
	
	@Autowired
	IClientRESTService adjectiveRestConsumer;

	@Override
	public String getWord() {
		return adjectiveRestConsumer.getWord();
	}
	
	@HystrixCommand(fallbackMethod="getWord")
	public String getWordFallback(){
		return "Error con la aplicacion LAB-4-ADJECTIVE";
	}

}
