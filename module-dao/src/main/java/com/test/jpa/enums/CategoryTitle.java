package com.test.jpa.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum CategoryTitle {
	
	TECHNICAL("Technical");
	
	private String title;
	
	private  CategoryTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public static String to(CategoryTitle ct){
		
		Optional<String> cTitle =  Stream.of(CategoryTitle.values())
		                                        .filter( title -> (title == ct))
		                                        .map(CategoryTitle::getTitle)
		                                        .findFirst();
		return (cTitle.isPresent()) ? cTitle.get() : "";
		                        
		      
	}
	
	public static CategoryTitle from(String ct){
		
		return Enum.valueOf(CategoryTitle.class, ct);                        
		      
	}
	
	

}
