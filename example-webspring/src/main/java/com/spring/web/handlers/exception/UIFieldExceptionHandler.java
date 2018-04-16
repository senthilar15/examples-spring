package com.spring.web.handlers.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UIFieldExceptionHandler {
	
	
	@Autowired
	private MessageSource msgSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public UIFieldErrorMessages handleFieldErrors(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		Locale locale = LocaleContextHolder.getLocale();
	    UIFieldErrorMessages errorMsgs =  new UIFieldErrorMessages (HttpStatus.BAD_REQUEST.value() , HttpStatus.BAD_REQUEST.getReasonPhrase());
	    result.getFieldErrors().stream().forEach(e -> {
	    	String msg = msgSource.getMessage(e.getDefaultMessage(), null, locale);
	    	com.spring.web.handlers.exception.FieldError ferror = new com.spring.web.handlers.exception.FieldError(e.getField(),msg);
	    	errorMsgs.addFieldError(ferror);
	    });
	    return errorMsgs;
	}

}
