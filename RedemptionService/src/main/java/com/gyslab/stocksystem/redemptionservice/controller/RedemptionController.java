package com.gyslab.stocksystem.redemptionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.stocksystem.redemptionservice.request.RedemptionRequest;
import com.gyslab.stocksystem.redemptionservice.service.interfaces.RedemptionService;

@RestController
@RequestMapping(value = "/redemption")
public class RedemptionController {
	
	@Autowired
	RedemptionService redemptionService;
	
	@PostMapping
	public ResponseEntity redemption(@RequestBody RedemptionRequest request) {
		
		redemptionService.redeem(request);
		
		return ResponseEntity.ok().build();
	}
	
}
