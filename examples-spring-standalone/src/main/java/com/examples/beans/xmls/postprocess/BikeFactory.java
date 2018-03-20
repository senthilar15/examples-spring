package com.examples.beans.xmls.postprocess;

public class BikeFactory {
	
	
	
 public  Bike getBike(String brand) {
		
		if(brand == "Royal-enfield") {
			return new RoyalEnfield();
		}
		if(brand == "Hero") {
			return new Hero();
		}
		
		return new Bike();
	}
	
	

}
