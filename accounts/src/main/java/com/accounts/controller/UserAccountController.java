package com.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.dto.UserAccountDTO;
import com.accounts.entity.UserAccount;
import com.accounts.service.UserAccountService;

@RestController
@RequestMapping("/userSavingsAccount")
public class UserAccountController {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);

	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public ResponseEntity<?> saveUserAccount( @RequestBody UserAccountDTO userAccountDTO ) {
		logger.info("Start -- Save a new UserAccount entity." );
		UserAccount userAccount = UserAccountDTO.toUserAccount(userAccountDTO);
		userAccountService.saveUserAccount(userAccount);
		userAccountDTO = UserAccountDTO.toUserAccountDTO(userAccount);
		logger.info("End -- Save a new UserAccount entity." );
		return new ResponseEntity<UserAccountDTO>( userAccountDTO, HttpStatus.OK );
	}
	
}