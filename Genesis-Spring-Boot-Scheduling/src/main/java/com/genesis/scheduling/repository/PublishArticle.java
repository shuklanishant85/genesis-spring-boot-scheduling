package com.genesis.scheduling.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.genesis.scheduling.model.Article;
import com.genesis.scheduling.model.News;

@Component
public class PublishArticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublishArticle.class);
	@Autowired
	private APIConsumerRepository apiConsumerRepository;
	private Article article;

	public Article getArticle() {
		return article;
	}

	@Scheduled(cron = "0 30 * * * *")
	public void fetchNewArticleForDisplay() {
		LOGGER.info("fetching article from repo, published Articles");
		News news = apiConsumerRepository.getNewsRepository();
		if (null != news && !news.getArticles().isEmpty()) {
			LOGGER.info("{} articles present published Articles", news.getArticles().size());
			article = news.getArticles().get(0);
			news.getArticles().remove(0);
			LOGGER.info("removed displayed article form repository");
			LOGGER.info("{} articles present published Articles post update", news.getArticles().size());
		} else {
			apiConsumerRepository.fetchLatestNews();
			if (null != news && !news.getArticles().isEmpty()) {
				article = news.getArticles().get(0);
				news.getArticles().remove(0);
			}
		}
	}

}
