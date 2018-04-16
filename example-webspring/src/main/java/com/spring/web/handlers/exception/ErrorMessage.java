package com.spring.web.handlers.exception;

public class ErrorMessage {
	
	private int errorCode;
	private String message;
	
	
	public ErrorMessage(int code , String message) {
		this.errorCode = code;
		this.message = message;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
