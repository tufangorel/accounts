package com.accounts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.entity.Account;
import com.accounts.entity.UserAccount;
import com.accounts.entity.UserAccountPK;
import com.accounts.repository.AccountRepository;
import com.accounts.repository.UserAccountRepository;
import com.accounts.repository.UserRepository;
import com.accounts.validator.UserAccountValidator;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private UserAccountValidator userAccountValidator;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public void saveUserAccount( UserAccount userAccount ) {
		userAccountValidator.checkExistingUser(userAccount.getUser().getUserId());
		userAccountValidator.validateHour();
		userAccountValidator.checkExistingUserSavingsAccount( userAccount.getUser().getUserId() );
		userAccount.setUser(userRepository.findById(userAccount.getUser().getUserId()).get());
		Account currentAccount = userAccount.getAccount();
		accountRepository.save(currentAccount);
		userAccount.setUserAccountPK(new UserAccountPK(userAccount.getUser().getUserId(), userAccount.getAccount().getAccountId()));
		userAccountRepository.save(userAccount);
	}
	
}