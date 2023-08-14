package com.gyslab.stocksystem.portfolioservice.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Portfolio {
	
	Integer id;
	String name;
	Double amount;

}
