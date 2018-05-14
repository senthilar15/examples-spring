package com.spring.web.handlers.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DataAccessExceptionHandler {

	
	
	@ExceptionHandler(DataAccessException.class)
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	public ErrorMessage handleDataException(DataAccessException ex) {
		
		ErrorMessage errorMsgs = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
	    return errorMsgs;
	}
}
