package com.test.jpa.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.stream.Stream;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.slf4j.LoggerFactory;



public class DefaultRecordUpdateListener {
	
	 org.slf4j.Logger Logger = LoggerFactory.getLogger(DefaultRecordUpdateListener.class);
	
	 @PrePersist
	  protected void onCreate(Object record) { 
		 setStampDate(record); 
	  }

	  @PreUpdate
	  protected void onUpdate(Object record) {
		  setStampDate(record);
	  } 
	  
	  
	  private void setStampDate(Object record){
		 
		  Stream.of(record.getClass().getDeclaredMethods())
	            .filter(m -> m.getName().equalsIgnoreCase("setStampDate"))
	            .findFirst()
	            .ifPresent(m -> {	
	        	try {
					 
	        		 m.invoke(record, new  Timestamp(System.currentTimeMillis()));
	 			
	 			} catch (SecurityException | IllegalAccessException | IllegalArgumentException
	 					| InvocationTargetException e) {
	 				Logger.error("Error While update default value",e);
	 			}
	         });
	  }

}
