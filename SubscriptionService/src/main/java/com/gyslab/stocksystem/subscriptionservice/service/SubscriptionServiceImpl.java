package com.gyslab.stocksystem.subscriptionservice.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gyslab.stocksystem.subscriptionservice.request.AddPortfolioRequest;
import com.gyslab.stocksystem.subscriptionservice.request.AmountRequest;
import com.gyslab.stocksystem.subscriptionservice.request.SubscriptionRequest;
import com.gyslab.stocksystem.subscriptionservice.service.interfaces.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void subscribe(SubscriptionRequest req) {
		 kafkaTemplate.send("subscription", req);
	}
	
	@KafkaListener(topics = "subscription", groupId = "group1")
	public void subscriptionListener(SubscriptionRequest message) {
		
		deduct(message.getAmount());
		
		addPortfolio(message.getPortfolioName(), message.getAmount());
		
	}
	
	void deduct(Double amount) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		new RestTemplate().exchange(
				"http://localhost:8081/account/deduct"
				, HttpMethod.POST
				, new HttpEntity<AmountRequest>(AmountRequest.builder().amount(amount).build(), requestHeaders)
				, Object.class);
	}
	
	void addPortfolio(String portfolioName, Double amount) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		new RestTemplate().exchange(
				"http://localhost:8082/portfolio/add"
				, HttpMethod.POST
				, new HttpEntity<AddPortfolioRequest>(AddPortfolioRequest.builder().portfolioName(portfolioName).amount(amount).build(), requestHeaders)
				, Object.class);
	}

}
