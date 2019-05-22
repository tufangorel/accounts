package com.accounts.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionResponse> businessExceptionControl( BusinessException businessException,
			HttpServletRequest httpreq ) {
		ExceptionResponse exceptionResponse = getExceptionResponse(businessException.getErrorList());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}

	private ExceptionResponse getExceptionResponse(List<String> messages) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		if (messages != null && !messages.isEmpty()) {
            exceptionResponse.setMsgList(messages);
		}
		return exceptionResponse;
	}

}