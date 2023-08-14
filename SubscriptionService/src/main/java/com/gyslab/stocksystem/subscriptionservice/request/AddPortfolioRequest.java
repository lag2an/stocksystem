package com.gyslab.stocksystem.subscriptionservice.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddPortfolioRequest {
	
	String portfolioName;
	Double amount;

}
