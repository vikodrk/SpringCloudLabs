package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.services.IAdjectiveService;
import com.example.services.IArticleService;
import com.example.services.IClientService;
import com.example.services.INounService;
import com.example.services.IVerbService;
import com.example.services.impl.AdjectiveService;
import com.example.services.impl.ArticleService;
import com.example.services.impl.ClientService;
import com.example.services.impl.NounService;
import com.example.services.impl.VerbService;

@Configuration
public class ConfigClassLab7 {

	@Bean
	public IAdjectiveService adjectiveService() {
		return new AdjectiveService();
	}

	@Bean
	public IArticleService articleService() {
		return new ArticleService();
	}

	@Bean
	public IClientService clientService() {
		return new ClientService();
	}

	@Bean
	public INounService nounService() {
		return new NounService();
	}

	@Bean
	public IVerbService verbService() {
		return new VerbService();
	}

}
