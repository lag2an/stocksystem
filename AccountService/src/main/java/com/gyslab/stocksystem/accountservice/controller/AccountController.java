package com.gyslab.stocksystem.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.stocksystem.accountservice.request.AddAccountRequest;
import com.gyslab.stocksystem.accountservice.request.AmountRequest;
import com.gyslab.stocksystem.accountservice.response.AccountResponse;
import com.gyslab.stocksystem.accountservice.response.TopupResponse;
import com.gyslab.stocksystem.accountservice.service.interfaces.AccountService;
import com.gyslab.stocksystem.accountservice.service.interfaces.DeductService;
import com.gyslab.stocksystem.accountservice.service.interfaces.TopupService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	TopupService topupService;
	
	@Autowired
	DeductService deductService;
	
	@GetMapping
	public ResponseEntity<AccountResponse> getAccount(@AuthenticationPrincipal Jwt jwt) throws Exception{
		
		Integer id = Integer.valueOf(jwt.getSubject());
		
		return ResponseEntity.ok(accountService.get(id));
		
	}
	
	@PostMapping
	public ResponseEntity addAccount(@RequestBody AddAccountRequest request) throws Exception{
		
		accountService.addAccount(request);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping(value = "/topup")
	public ResponseEntity<TopupResponse> toptup(@RequestBody AmountRequest request, @AuthenticationPrincipal Jwt jwt) throws Exception{
		Integer id = Integer.valueOf(jwt.getSubject());
		
		topupService.topup(id, request.getAmount());
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "/deduct")
	public ResponseEntity<TopupResponse> deduct(@RequestBody AmountRequest request, @AuthenticationPrincipal Jwt jwt){
		Integer id = Integer.valueOf(jwt.getSubject());
		
		deductService.deduct(1, request.getAmount());
		
		return ResponseEntity.ok().build();
	}
}
