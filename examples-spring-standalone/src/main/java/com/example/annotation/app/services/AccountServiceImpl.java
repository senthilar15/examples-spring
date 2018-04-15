package com.example.annotation.app.services;

import org.springframework.stereotype.Service;

import com.example.annotation.aspects.Transactional;

@Service
public class AccountServiceImpl implements AccountService{

	

	@Override
	public void transfer() {
		System.out.println("Account Service");		
	}
	
	@Transactional
	public void annotatedTransfer() {
		System.out.println("around Service");		
	}
	
	
	

}
