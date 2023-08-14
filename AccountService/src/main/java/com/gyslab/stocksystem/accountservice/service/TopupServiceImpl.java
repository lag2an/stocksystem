package com.gyslab.stocksystem.accountservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.accountservice.entity.Account;
import com.gyslab.stocksystem.accountservice.repository.AccountRepository;
import com.gyslab.stocksystem.accountservice.service.interfaces.TopupService;

@Service
public class TopupServiceImpl implements TopupService{
	
	@Autowired
	AccountRepository accountRepo;
	
	public void topup(Integer id, Double amount) throws Exception {
		Optional<Account> acc = accountRepo.findById(id);
		
		if(acc.isEmpty())
			throw new Exception("No account found");
		
		acc.get().setBalance(acc.get().getBalance() + amount);
		
		accountRepo.save(acc.get());
	}

}
