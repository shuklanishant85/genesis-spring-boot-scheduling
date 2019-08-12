package com.genesis.scheduling.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.scheduling.model.Article;
import com.genesis.scheduling.repository.PublishArticle;

@Service
public class ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private PublishArticle publishArticle;

	public Article getLatestArticle() {
		LOGGER.info("fetching the latest article from Repository");
		return publishArticle.getArticle();
	}
}
