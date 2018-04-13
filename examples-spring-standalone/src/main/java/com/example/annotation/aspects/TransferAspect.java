package com.example.annotation.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransferAspect {
	
	
	@Before("com.example.annotation.aspects.AppPointCuts.transfer()")
	private void anyOldTransfer() {
		
		System.out.println("Called Any old transfer ");
		
	}

}
