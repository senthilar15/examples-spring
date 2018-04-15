package com.example.annotation.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TransferAspect {
	
	
	@Before("com.example.annotation.aspects.AppPointCuts.transfer()")
	private void anyOldTransfer() {
		
		System.out.println("Called Any old transfer ");
		
	}
	
	
	@AfterReturning("com.example.annotation.aspects.AppPointCuts.transferWithin()")
	private void within() {
		
		System.out.println("Called within ");
		
	}
	
	
	@AfterReturning(pointcut="com.example.annotation.aspects.AppPointCuts.transferWithin()",returning="value")
	private void within(Object value) {
		
		System.out.println("@AfterReturning >>> Called within :: "+value);
		
	}
	
	
	@AfterThrowing(pointcut="com.example.annotation.aspects.AppPointCuts.transferWithin()",throwing="ex")
	private void within(IllegalArgumentException ex) {
		
		System.out.println("@@AfterThrowing >>> Called within :: "+ex.getStackTrace());
		
	}
	
	@After("com.example.annotation.aspects.AppPointCuts.transferWithin()")
	private void after() {
		
		System.out.println("Clearing up...");
		
	}
	
	
	
	@Before("com.example.annotation.aspects.AppPointCuts.accountTransfer()")
	public void beforeTransfer() {
		
		System.out.println("Account Service aspect");
	}
	
	@Around("com.example.annotation.aspects.AppPointCuts.annotatedTransfer()")
	public void aroundTransfer(ProceedingJoinPoint pjp) {
		
		System.out.println("Before");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After");
		
		
	}
	

}
