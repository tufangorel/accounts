package com.accounts.dto;

import java.io.Serializable;

import com.accounts.entity.Account;
import com.accounts.entity.User;
import com.accounts.entity.UserAccount;

public class UserAccountDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private Integer accountId;
	
	public static UserAccountDTO toUserAccountDTO( UserAccount userAccount ) {
		UserAccountDTO userAccountDTO = new UserAccountDTO();
		userAccountDTO.setAccountId(userAccount.getAccount().getAccountId());
		userAccountDTO.setUserId(userAccount.getUser().getUserId());
		return userAccountDTO;
	}
	
	public static UserAccount toUserAccount(UserAccountDTO userAccountDTO) {
		UserAccount userAccount = new UserAccount();
		userAccount.setUser( new User( userAccountDTO.getUserId() ));
		userAccount.setAccount(new Account());
		return userAccount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}