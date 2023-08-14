package com.gyslab.stocksystem.portfolioservice.response;

import java.util.List;

import com.gyslab.stocksystem.portfolioservice.service.model.Portfolio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPortfolioResponse {
	
	List<Portfolio> data;

}
