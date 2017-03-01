package com.example.rest.ws.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("LAB-4-ARTICLE")
public interface IArticleRESTService {

	@RequestMapping(method=RequestMethod.GET,value="/")
	String getWord();
	
}
