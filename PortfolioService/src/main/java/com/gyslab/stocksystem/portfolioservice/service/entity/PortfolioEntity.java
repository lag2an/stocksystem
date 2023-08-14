package com.gyslab.stocksystem.portfolioservice.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PortfolioEntity {
	
	@Id
	Integer id;
	String portfolioName;
	Integer accountId;
	Double amount;
	

}
