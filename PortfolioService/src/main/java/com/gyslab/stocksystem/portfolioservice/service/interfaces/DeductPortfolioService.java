package com.gyslab.stocksystem.portfolioservice.service.interfaces;

import com.gyslab.stocksystem.portfolioservice.service.request.DeductPortfolioRequest;

public interface DeductPortfolioService {
	
	void deductPortfolio(DeductPortfolioRequest request) throws Exception;

}
