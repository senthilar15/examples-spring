package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bike {

	
	@PostConstruct
	public void init() {
		
		System.out.println("Bike initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("Bike closed");
	}
}
