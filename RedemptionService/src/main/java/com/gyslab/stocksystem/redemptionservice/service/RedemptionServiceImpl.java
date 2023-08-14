package com.gyslab.stocksystem.redemptionservice.service;

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

import com.gyslab.stocksystem.redemptionservice.request.AmountRequest;
import com.gyslab.stocksystem.redemptionservice.request.DeductPortfolioRequest;
import com.gyslab.stocksystem.redemptionservice.request.RedemptionRequest;
import com.gyslab.stocksystem.redemptionservice.service.interfaces.RedemptionService;

@Service
public class RedemptionServiceImpl implements RedemptionService{
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void redeem(RedemptionRequest req) {
		 kafkaTemplate.send("redemption", req);
	}
	
	@KafkaListener(topics = "redemption", groupId = "group1")
	public void subscriptionListener(RedemptionRequest message) {
		
		deductPortfolio(message.getPortfolioName(), message.getAmount());
		
		add(message.getAmount());
	}
	
	void add(Double amount) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		new RestTemplate().exchange(
				"http://localhost:8081/account/topup"
				, HttpMethod.POST
				, new HttpEntity<AmountRequest>(AmountRequest.builder().amount(amount).build(), requestHeaders)
				, Object.class);
	}
	
	void deductPortfolio(String portfolioName, Double amount) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		new RestTemplate().exchange(
				"http://localhost:8082/portfolio/deduct"
				, HttpMethod.POST
				, new HttpEntity<DeductPortfolioRequest>(DeductPortfolioRequest.builder().portfolioName(portfolioName).amount(amount).build(), requestHeaders)
				, Object.class);
	}

}
