package com.accounts.dto;

import java.io.Serializable;

import com.accounts.entity.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public UserDTO() {
	}
	
	private Integer userId;
	private String name;
	
	public static UserDTO toUserDTO( User user ) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setName(user.getName());
		return userDTO;
	}
	
	public static User toUser(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setName(userDTO.getName());
		return user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}