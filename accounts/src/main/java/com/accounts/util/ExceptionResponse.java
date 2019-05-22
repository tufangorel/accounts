package com.accounts.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

    private List<String> msgList;
    
    public ExceptionResponse() {
	}

	public List<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<String> msgList) {
		this.msgList = msgList;
	}
    
}