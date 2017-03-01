package com.example.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rest.ws.consumer.IArticleRESTService;
import com.example.services.IArticleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class ArticleService implements IArticleService{
	
	@Autowired
	IArticleRESTService adjectiveRestConsumer;

	@Override
	public String getWord() {
		return adjectiveRestConsumer.getWord();
	}
	
	@HystrixCommand(fallbackMethod="getWord")
	public String getWordFallback(){
		return "Error con la aplicacion LAB-4-ARTICLE";
	}

}
