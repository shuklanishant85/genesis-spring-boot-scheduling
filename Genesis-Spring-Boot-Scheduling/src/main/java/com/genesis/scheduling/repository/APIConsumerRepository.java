package com.genesis.scheduling.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.genesis.scheduling.cron.TimeGenerator;
import com.genesis.scheduling.model.News;

@Component
public class APIConsumerRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(APIConsumerRepository.class);
	private static final String URI = "https://newsapi.org/v2/everything?q=india&sortBy=publishedAt&apiKey=637bdd3a8b134eabaf7b764f0d74f12b";
	private News newsRepository;
	@Autowired
	private TimeGenerator timeGenerator;

	public News getNewsRepository() {
		return newsRepository;
	}

	/**
	 * Scheduled annotation defines when a particular method runs. FixedRate
	 * specifies the interval between method invocations (start). FixedDelay
	 * specifies the interval between invocations (completion). @Scheduled(cron="")
	 * expressions for more sophisticated cron based task scheduling.
	 */
	@Scheduled(fixedRate = 300000)
	public void fetchLatestNews() {
		timeGenerator.printCurrentTime();
		LOGGER.info("updating the repository with latest news ");
		newsRepository = callNewsAPI();
	}

	public News callNewsAPI() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<News> news = restTemplate.getForEntity(URI, News.class);
		return news.getBody();
	}

}
