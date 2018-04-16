package com.spring.web.handlers.exception;

import java.util.ArrayList;
import java.util.List;

public class UIFieldErrorMessages extends ErrorMessage{
	

	private List<FieldError> fieldErrors;
	
	public  UIFieldErrorMessages(int code , String message){
		super(code, message);
	}
	
	public void addFieldError(FieldError ferror) {
		
		if(fieldErrors == null) {
			fieldErrors = new ArrayList<>();
		}
		fieldErrors.add(ferror);
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
	
}
