package com.gyslab.stocksystem.portfolioservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.portfolioservice.service.interfaces.GetPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.model.Portfolio;
import com.gyslab.stocksystem.portfolioservice.service.repository.PortfolioRepository;

@Service
public class GetPortfolioServiceImpl implements GetPortfolioService{
	
	@Autowired
	PortfolioRepository portfolioRepo;

	public List<Portfolio> getPortfolio(){
		
		List<Portfolio> result = new ArrayList<>();
		
		portfolioRepo.findByAccountId(1).forEach(x -> 
			result.add(
					Portfolio.builder()
					.id(x.getId())
					.name(x.getPortfolioName())
					.amount(x.getAmount())
					.build()
					)
		);
		
		return result;
		
	}
}
