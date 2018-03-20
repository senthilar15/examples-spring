package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Audi extends Car{
	
	@PostConstruct
	public void init() {
		
		System.out.println("Audi initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("Audi closed");
	}

}
