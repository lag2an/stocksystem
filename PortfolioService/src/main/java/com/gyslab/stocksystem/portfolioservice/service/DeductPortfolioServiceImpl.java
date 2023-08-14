package com.gyslab.stocksystem.portfolioservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.portfolioservice.service.entity.PortfolioEntity;
import com.gyslab.stocksystem.portfolioservice.service.interfaces.DeductPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.repository.PortfolioRepository;
import com.gyslab.stocksystem.portfolioservice.service.request.DeductPortfolioRequest;

@Service
public class DeductPortfolioServiceImpl implements DeductPortfolioService{
	
	@Autowired
	PortfolioRepository portfolioRepo;

	@Override
	public void deductPortfolio(DeductPortfolioRequest request) throws Exception{
		
		PortfolioEntity entity = portfolioRepo.findByAccountIdAndPortfolioName(1, request.getPortfolioName());
		if(entity == null) 
			throw new Exception("Portfolio not exist");
		
		if(entity.getAmount() < request.getAmount())
			throw new Exception("Portfolio value not enough");
		
		if(entity.getAmount().equals(request.getAmount())) {
			portfolioRepo.delete(entity);
		}
		else {
			entity.setAmount(entity.getAmount() - request.getAmount());
			portfolioRepo.save(entity);
		}
			
		
		
	}
}
