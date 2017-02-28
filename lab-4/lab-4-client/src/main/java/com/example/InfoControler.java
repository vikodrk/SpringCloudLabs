package com.example;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoControler {

	@Value("${info}")
	String info;
	
	@RequestMapping("/info")
	public @ResponseBody String getInfo(){
		return info;
	}
	
}
