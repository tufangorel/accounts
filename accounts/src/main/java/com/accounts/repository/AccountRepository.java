package com.accounts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.accounts.entity.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>{

}