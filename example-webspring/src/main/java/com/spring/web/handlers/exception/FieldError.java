package com.spring.web.handlers.exception;

public class FieldError {
	
	private String fieldName;
	private String errorMsg;
	
	FieldError(String fieldName, String errorMsg){
		
		this.fieldName = fieldName;
		this.errorMsg = errorMsg;
		
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
