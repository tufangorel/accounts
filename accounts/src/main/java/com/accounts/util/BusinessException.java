package com.accounts.util;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private List<String> errorList;

	public BusinessException() {
		super();
	}
	
	public BusinessException(List<String> errorList) {
		this.errorList = errorList;
	}

	public BusinessException(String metaMessage) {
		List<String> errorList = new ArrayList<String>();
		errorList.add(metaMessage);
		this.errorList = errorList;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
}