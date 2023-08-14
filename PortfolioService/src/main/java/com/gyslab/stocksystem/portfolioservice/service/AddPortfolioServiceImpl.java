package com.gyslab.stocksystem.portfolioservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.portfolioservice.service.entity.PortfolioEntity;
import com.gyslab.stocksystem.portfolioservice.service.interfaces.AddPortfolioService;
import com.gyslab.stocksystem.portfolioservice.service.repository.PortfolioRepository;
import com.gyslab.stocksystem.portfolioservice.service.request.AddPortfolioRequest;

@Service
public class AddPortfolioServiceImpl implements AddPortfolioService{
	
	@Autowired
	PortfolioRepository portfolioRepo;

	@Override
	public void addPortfolio(AddPortfolioRequest request){
		
		PortfolioEntity entity = portfolioRepo.findByAccountIdAndPortfolioName(1, request.getPortfolioName());
		if(entity == null) {
			int total = (int) portfolioRepo.count();
			entity = PortfolioEntity.builder()
					.id(total + 1)
					.accountId(1)
					.portfolioName(request.getPortfolioName())
					.amount(Double.valueOf(0))
					.build();
		}
		
		entity.setAmount(entity.getAmount() + request.getAmount());
		
		portfolioRepo.save(entity);
	}
}
