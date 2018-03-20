package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hero extends Bike{

	@PostConstruct
	public void init() {
		
		System.out.println("Hero initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("Hero closed");
	}
}
