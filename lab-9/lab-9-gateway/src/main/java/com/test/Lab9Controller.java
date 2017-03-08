package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lab9Controller {


	@RequestMapping("/")
	public String buildSentence() {
		return "template";
	}

}
