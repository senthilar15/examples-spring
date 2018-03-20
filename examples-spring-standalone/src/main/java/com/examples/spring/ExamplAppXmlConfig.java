package com.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExamplAppXmlConfig {

	private static ApplicationContext context;
	
	private ExamplAppXmlConfig() {
		
	}
	
	
	public static void configure() {
		 context = new ClassPathXmlApplicationContext("spring-app-context.xml",
				 "lazy-autowire.xml","dependency-injection.xml",
				 "spring-dependency-method-injection.xml","bean-scope-and-lifecycle.xml");
		 ((ConfigurableApplicationContext )context).registerShutdownHook(); //to call all destroy methods of singleton bean
	
	}
	
	public static void close() {
		
		((ClassPathXmlApplicationContext)context).close();
		
	}
	
	
	
	public static <T> T lookupBean(Class<T> clazz) {
		
		if(context == null) {
			configure();
		}
		return context.getBean(clazz);
	}
	
  public static <T> T lookupBeanByName(String name , Class<T> clazz) {
		
		if(context == null) {
			configure();
		}
		return context.getBean(name, clazz);
	}
  
  
  
  public static <T, R> R lookupBeanByName(String name , Class<T> clazz , Class<R> returnClazz) {
		
		if(context == null) {
			configure();
		}
		return  (R)context.getBean(name, clazz);
	}
	
}
