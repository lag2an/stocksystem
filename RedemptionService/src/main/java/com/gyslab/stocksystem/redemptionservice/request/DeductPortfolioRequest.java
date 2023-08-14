package com.gyslab.stocksystem.redemptionservice.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeductPortfolioRequest {
	
	String portfolioName;
	Double amount;

}
