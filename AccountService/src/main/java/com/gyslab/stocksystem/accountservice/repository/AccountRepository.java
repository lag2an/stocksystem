package com.gyslab.stocksystem.accountservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.gyslab.stocksystem.accountservice.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

}
