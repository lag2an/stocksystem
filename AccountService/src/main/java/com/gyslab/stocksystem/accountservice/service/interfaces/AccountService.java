package com.gyslab.stocksystem.accountservice.service.interfaces;

import java.util.List;

import com.gyslab.stocksystem.accountservice.request.AddAccountRequest;
import com.gyslab.stocksystem.accountservice.response.AccountResponse;

public interface AccountService {
	
	List<AccountResponse> get();
	AccountResponse get(Integer id) throws Exception;
	
	void addAccount(AddAccountRequest request) throws Exception;

}
