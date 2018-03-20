package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RoyalEnfield extends Bike {

	

	@PostConstruct
	public void init() {
		
		System.out.println("RoyalEnfield initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("RoyalEnfield closed");
	}
}
