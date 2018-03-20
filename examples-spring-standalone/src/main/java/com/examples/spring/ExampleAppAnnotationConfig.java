package com.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.annotation.movies.config.MovieConfiguration;

public class ExampleAppAnnotationConfig {
	
private static ApplicationContext context;
	
	private ExampleAppAnnotationConfig() {
		
	}
	
	
	public static void configure() {
		 context = new AnnotationConfigApplicationContext(MovieConfiguration.class);
		 ((ConfigurableApplicationContext )context).registerShutdownHook(); //to call all destroy methods of singleton bean
	
	}
	
	public static void close() {
		
		((AnnotationConfigApplicationContext)context).close();
		
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
