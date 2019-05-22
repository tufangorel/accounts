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

import com.accounts.dto.UserDTO;
import com.accounts.entity.User;
import com.accounts.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public ResponseEntity<?> saveUser( @RequestBody UserDTO userDTO ) {
		logger.info("Start -- Save a new User entity." );
		User user = UserDTO.toUser(userDTO);
		userService.saveUser(user);
		userDTO = UserDTO.toUserDTO(user);
		logger.info("End -- Save a new User entity." );
		return new ResponseEntity<UserDTO>( userDTO, HttpStatus.OK );
	}
}
