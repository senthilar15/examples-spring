package com.spring.web.handlers.exception;

public class UIFieldErrorMessages extends ErrorMessage{
	
	private String fieldName;
	
	public  UIFieldErrorMessages(String fieldName, int code , String message){
		super(code, message);
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	

}
