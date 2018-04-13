package com.example.annotation.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppPointCuts {
	
	@Pointcut("execution(* com.example.annotation.app.*.*.transfer(..))")
	public void transfer() {}
	

}
