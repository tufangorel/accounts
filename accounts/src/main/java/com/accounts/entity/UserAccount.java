package com.accounts.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserAccount() {
	}
	
	public UserAccount( UserAccountPK userAccountPK ) {
		this.userAccountPK=userAccountPK;
	}
	
    @EmbeddedId
    private UserAccountPK userAccountPK;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(cascade = {CascadeType.ALL}, optional = false)
    private User user;
    
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID",  nullable = false, insertable = false, updatable = false)
    @OneToOne(cascade = {CascadeType.ALL}, optional = false)
    private Account account;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UserAccountPK getUserAccountPK() {
		return userAccountPK;
	}

	public void setUserAccountPK(UserAccountPK userAccountPK) {
		this.userAccountPK = userAccountPK;
	}

}