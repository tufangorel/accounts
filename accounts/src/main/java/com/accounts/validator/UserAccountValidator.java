package com.accounts.validator;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accounts.entity.User;
import com.accounts.repository.UserAccountRepository;
import com.accounts.repository.UserRepository;
import com.accounts.util.BusinessException;

@Component
public class UserAccountValidator {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	public void validateHour() {
		
		LocalTime localTimeNow = LocalTime.now();
		
		LocalTime begin = LocalTime.of( 8, 0 );  // 8 AM.
		LocalTime end = LocalTime.of( 17, 0 );  // 17 PM.
		
		if( !(localTimeNow.isAfter(begin) && localTimeNow.isBefore(end)) )
			throw new BusinessException("The account can only be opened between 8 AM and 5 PM");
	}

	public void checkExistingUser(Integer userId) {
		
		if( userId == null )
			throw new BusinessException("User ID must be provided.");
		Optional<User> user = userRepository.findById(userId);
		if( !user.isPresent() )
			throw new BusinessException("User does not exist in the system. Save user before savings account creation.");
	}

	public void checkExistingUserSavingsAccount(Integer userId) {
		
		if( userId == null )
			throw new BusinessException("User ID must be provided.");
		
		int count = userAccountRepository.findUserAccountByUserId(userId);
		if( count > 0 )
			throw new BusinessException("User can have only one savings account. Duplicate savings account creation is not allowed.");
	}

}
