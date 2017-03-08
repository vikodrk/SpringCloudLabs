package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Lab9Controller {

	@RequestMapping("/info")
	public @ResponseBody String infoMethod() {
		return "Lab 9 Gateway API";
	}

	@RequestMapping("/")
	public String buildSentence() {
		return "template";
	}

}
