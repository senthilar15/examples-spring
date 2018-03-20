package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Tesla extends Car{

	
	@PostConstruct
	public void init() {
		
		System.out.println("Tesla initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("Tesla closed");
	}
}
