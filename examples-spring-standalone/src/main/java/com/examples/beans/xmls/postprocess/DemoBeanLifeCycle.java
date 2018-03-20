package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * 
 * 
 *The destroy-method attribute of a <bean> element can be assigned a special 
 *(inferred) value which instructs Spring to automatically 
 *detect a public close or shutdown method on the specific bean 
 *class (any class that implements java.lang.AutoCloseable or 
 *java.io.Closeable would therefore match). 
 *This special (inferred) value can also be set on the default-destroy-method 
  *attribute of a <beans> element to apply this behavior to an entire set
 * of beans (see Default initialization and destroy methods). 
 * Note that this is the default behavior with Java config.
 *
 */



public class DemoBeanLifeCycle implements InitializingBean, DisposableBean,AutoCloseable  {

	@Override //-- priority 2
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initialized through afterPropertiesSet InitializingBean");
	}
	
	@PostConstruct //-- priority 1
	public void setup() {
		System.out.println("Initialized through @PostConstruct");
	}
	
	//-- priority 3
	public void init() {
		System.out.println("Initialized through init-method , may be used with default-init-method");
	}
	//-- priority 3
	public void close() {
		System.out.println("destroyed  through  destroy-method , may be used with default-destroy-method");
	}
	
	@PreDestroy //-- priority 1
	public void cleanup() {
		System.out.println("destroyed  through  @PreDestroy");
	}

	@Override //-- priority 2
	public void destroy() throws Exception {
		System.out.println("destroyed  through  destroy DisposableBean");
	}

}
