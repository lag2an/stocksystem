package com.gyslab.stocksystem.subscriptionservice.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubscriptionRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2618449377508412874L;
	String portfolioName;
	Double amount;

}
