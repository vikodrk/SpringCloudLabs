package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab9InfoController {

	@Value("${info}")
	private String info;

	@RequestMapping("/info")
	public @ResponseBody String infoMethod() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
