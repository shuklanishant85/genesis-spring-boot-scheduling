package com.genesis.scheduling.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.scheduling.model.Article;
import com.genesis.scheduling.service.ArticleService;

@RestController
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ArticleService articleService;

	@Value("${spring.application.name}")
	String applicationName;

	@RequestMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("applicationName", applicationName);
		return "HomePage";
	}

	@GetMapping("/news/getlatest")
	public Article getLatestArticle() {
		LOGGER.info("creating article response application");
		return articleService.getLatestArticle();
	}
}
