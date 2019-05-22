package com.accounts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAccountPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "USER_ID", nullable = false)
    private Integer userId;
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Integer accountId;
    
    public UserAccountPK() {
	}

    public UserAccountPK(Integer userId, Integer accountId) {
    	this.userId=userId;
    	this.accountId=accountId;
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

	@Override
	public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccountPK other = (UserAccountPK) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
    
}