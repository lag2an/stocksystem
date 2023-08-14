package com.gyslab.stocksystem.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.accountservice.entity.Account;
import com.gyslab.stocksystem.accountservice.repository.AccountRepository;
import com.gyslab.stocksystem.accountservice.service.interfaces.DeductService;

@Service
public class DeductServiceImpl implements DeductService{
	
	@Autowired
	AccountRepository accountRepo;
	
	public void deduct(Integer id, Double amount) {
		Account acc = accountRepo.findById(id).orElseThrow();
		
		acc.setBalance(acc.getBalance() - amount);
		
		accountRepo.save(acc);
	}

}
