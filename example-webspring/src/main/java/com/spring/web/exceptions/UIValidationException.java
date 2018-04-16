package com.spring.web.exceptions;

public class UIValidationException extends RuntimeException{

	private static final long serialVersionUID = -5768945612673551030L;
	
	private int errorCode;
	private String field;
	
	public UIValidationException() {
        super();
    }
    public UIValidationException(int errorCode, String field, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.field = field;
    }
    public UIValidationException(int errorCode, String field,String message) {
        super(message);
        this.errorCode = errorCode;
        this.field = field;
    }
    public UIValidationException(int errorCode, String field, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.field = field;
    }
    
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
    
    

}
