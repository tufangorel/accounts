package com.accounts.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accounts.entity.UserAccount;

@Repository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Integer> {
	
	@Query("select count(1) from UserAccount u where u.user.userId=:userId")
	public int findUserAccountByUserId( @Param("userId") Integer userId );

}