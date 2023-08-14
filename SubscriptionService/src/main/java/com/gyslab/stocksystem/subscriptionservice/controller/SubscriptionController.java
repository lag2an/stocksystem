package com.gyslab.stocksystem.subscriptionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.stocksystem.common.model.EmptyModel;
import com.gyslab.stocksystem.subscriptionservice.request.SubscriptionRequest;
import com.gyslab.stocksystem.subscriptionservice.service.interfaces.SubscriptionService;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping
	public ResponseEntity<EmptyModel> subscribe(@RequestBody SubscriptionRequest request){
		
		subscriptionService.subscribe(request);
		
		return ResponseEntity.ok().build();
		
	}
	
}
