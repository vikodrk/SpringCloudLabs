package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockyController {

	@Value("${lucky-world}")String lockyWord;
	
	@RequestMapping("/lucky-word")
	public String showLuckyWord(){
		return "The lucky word is: " + lockyWord;
	}
	
}
