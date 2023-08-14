package com.gyslab.stocksystem.portfolioservice.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gyslab.stocksystem.portfolioservice.service.entity.PortfolioEntity;

public interface PortfolioRepository extends CrudRepository<PortfolioEntity, Integer>{
	
	public List<PortfolioEntity> findByAccountId(Integer accountId);
	
	public PortfolioEntity findByAccountIdAndPortfolioName(Integer accountId, String portfolioName);

}
