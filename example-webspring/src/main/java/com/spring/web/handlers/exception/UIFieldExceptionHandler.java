package com.spring.web.handlers.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.web.exceptions.UIValidationException;

@RestControllerAdvice
public class UIFieldExceptionHandler {
	
	
	
	@ExceptionHandler(UIValidationException.class)
	public UIFieldErrorMessages handleNotFoundException(UIValidationException ex) {
		return new UIFieldErrorMessages(ex.getField() , ex.getErrorCode() ,ex.getMessage());
	}

}
