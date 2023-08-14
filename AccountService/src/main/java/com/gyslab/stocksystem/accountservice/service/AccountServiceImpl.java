package com.gyslab.stocksystem.accountservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyslab.stocksystem.accountservice.entity.Account;
import com.gyslab.stocksystem.accountservice.repository.AccountRepository;
import com.gyslab.stocksystem.accountservice.request.AddAccountRequest;
import com.gyslab.stocksystem.accountservice.response.AccountResponse;
import com.gyslab.stocksystem.accountservice.service.interfaces.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepo;
	
	public List<AccountResponse >get() {
		List<AccountResponse> response = new ArrayList<>();
		
		accountRepo.findAll().forEach(x ->
			response.add(AccountResponse.builder().id(x.getId()).fullname(x.getFullName()).build())
		);
		
		return response;
	}

	@Override
	public AccountResponse get(Integer id) throws Exception {
		
		Optional<Account> account = accountRepo.findById(id);
		
		if(account.isEmpty())
			throw new Exception("account not found");
		
		return AccountResponse.builder().id(account.get().getId()).fullname(account.get().getFullName()).balance(account.get().getBalance())
				.build();
	}
	
	public void addAccount(AddAccountRequest request) throws Exception {
		
		Optional<Account> account = accountRepo.findById(request.getId());
		
		if(!account.isEmpty())
			throw new Exception("account id already exist");
		
		accountRepo.save(Account.builder().id(request.getId()).fullName(request.getFullname()).balance(0d).build());
	}

}
