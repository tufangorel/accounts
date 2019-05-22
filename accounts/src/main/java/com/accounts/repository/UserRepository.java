package com.accounts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.accounts.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
