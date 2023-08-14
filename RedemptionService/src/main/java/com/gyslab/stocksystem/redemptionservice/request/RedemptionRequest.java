package com.gyslab.stocksystem.redemptionservice.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RedemptionRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5099615277704462840L;
	String portfolioName;
	Double amount;

}
