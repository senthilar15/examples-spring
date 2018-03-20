package com.examples.beans.xmls.postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {
	
	@PostConstruct
	public void init() {
		
		System.out.println("Car initailzed");
		
	}
	
	@PreDestroy
	public void close() {
		
		System.out.println("Car closed");
	}
	
public static Car getCar(String brand) {
		
		if(brand.equalsIgnoreCase("Audi")) {
			return new Audi();
		}
		if(brand.equalsIgnoreCase("Tesla")) {
			return new Tesla();
		}
		
		return new Car();
	}
	

}
