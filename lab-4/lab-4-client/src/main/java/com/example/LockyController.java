package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LockyController {

	@Value("${words}")
	String words;

	@RequestMapping("/")
	public @ResponseBody Map<String, Object> showLuckyWord() {
		String[] wordArray = words.split(",");
		int i = (int) Math.round(Math.random() * (wordArray.length - 1));
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("word", wordArray[i]);
		return response;
	}

}
