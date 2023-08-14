package com.gyslab.stocksystem.portfolioservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.stocksystem.portfolioservice.response.GetPortfolioResponse;
import com.gyslab.stocksystem.portfolioservice.service.interfaces.AddPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.interfaces.DeductPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.interfaces.GetPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.request.AddPortfolioRequest;
import com.gyslab.stocksystem.portfolioservice.service.request.DeductPortfolioRequest;

@RestController
@RequestMapping(value = "/portfolio")
public class PortofolioController {
	
	@Autowired
	GetPortfolioService getPortfolioService;
	
	@Autowired
	AddPortfolioService addPortfolioService;
	
	@Autowired
	DeductPortfolioService deductPortfolioService;
	
	@GetMapping
	public ResponseEntity<GetPortfolioResponse> getPortfolio(){
		
		return ResponseEntity.ok(
			GetPortfolioResponse.builder().data(
				getPortfolioService.getPortfolio()
			).build()
		);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity addPortfolio(@RequestBody AddPortfolioRequest request){
		addPortfolioService.addPortfolio(request);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "/deduct")
	public ResponseEntity deductPortfolio(@RequestBody DeductPortfolioRequest request) throws Exception{
		deductPortfolioService.deductPortfolio(request);
		
		return ResponseEntity.ok().build();
	}

}
