package com.gyslab.stocksystem.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	@Id
	Integer id;
	
	@Column(name = "full_name")
	String fullName;
	
	@Column(name = "balance")
	Double balance;

}
