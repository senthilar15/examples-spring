package com.example.annotation.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppPointCuts {
	
	/*
	 * Method transfer under the package com.example.annotation.app.anyfolder.anyclass
	 * with any return type and zero or more arguments.
	 * 
	 * () -> method with no argument
	 * (*) -> method with one argument of any type
	 * (*, String) -> method with two argument of first argument of any type and seconf of String
	 * 
	 * 
	 */
	
	
	@Pointcut("execution(* com.example.annotation.app.*.*.transfer(..))")
	public void transfer() {}
	
	
	@Pointcut("within(com.example.annotation.app..*)")
	public void transferWithin() {}
	
	@Pointcut("target(com.example.annotation.app.services.AccountService)")
	public void accountTransfer() {}
	
	@Pointcut("@annotation(com.example.annotation.aspects.Transactional)")
	public void annotatedTransfer() {}
	
	
	
	

}
