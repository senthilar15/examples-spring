package com.examples.beans.xmls.postprocess;

public class CarFactory {
	
	
	public static Car getCar(String brand) {
		
		if(brand == "Audi") {
			return new Audi();
		}
		if(brand == "Tesla") {
			return new Tesla();
		}
		
		return null;
	}
	

}
