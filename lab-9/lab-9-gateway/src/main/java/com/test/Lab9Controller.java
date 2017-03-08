package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Lab9Controller {

	@Value("${info}")
	String info;

	@RequestMapping("/info")
	public @ResponseBody String infoMethod() {
		return info;
	}

	@RequestMapping("/")
	public String buildSentence() {
		return "template";
	}

}
