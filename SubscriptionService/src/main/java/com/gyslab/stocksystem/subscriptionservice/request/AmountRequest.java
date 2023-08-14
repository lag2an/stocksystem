package com.gyslab.stocksystem.subscriptionservice.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmountRequest {
	
	Double amount;

}
