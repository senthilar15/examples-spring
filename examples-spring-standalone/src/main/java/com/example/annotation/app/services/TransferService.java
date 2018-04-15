package com.example.annotation.app.services;

import org.springframework.stereotype.Service;

@Service
public class TransferService {
	

	public void transfer() {
		System.out.println("Called  transfer with no argument");
	}

	public void within() {
		System.out.println("Called  within service");
	}
	
	public String afterReturning() {
		System.out.println("After returning service");
		return "After returning value";
	}
	
	public void afterThrowing() {
	    //System.out.println("After returning service");
		throw new IllegalArgumentException("After returning Exception");
	}
	
	public void after() {
		  System.out.println("After service");
		 // throw new IllegalArgumentException("After  Exception");
	     
    }
	
	
	

}
