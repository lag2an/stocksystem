package com.gyslab.stocksystem.accountservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {
	
	Integer id;
	String fullname;
	Double balance;
}
