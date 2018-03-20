package com.examples.spring;

import com.examples.beans.xmls.Department;
import com.examples.beans.xmls.lazy.auto.Book;
import com.examples.beans.xmls.methodinjection.CommandManager;
import com.examples.beans.xmls.postprocess.Audi;
import com.examples.beans.xmls.postprocess.Bike;
import com.examples.beans.xmls.postprocess.BikeFactory;
import com.examples.beans.xmls.postprocess.Car;
import com.examples.beans.xmls.postprocess.CarFactory;
import com.examples.beans.xmls.postprocess.DemoBeanLifeCycle;
import com.examples.beans.xmls.postprocess.DemoBeanOverridedLifeCycle;
import com.examples.beans.xmls.postprocess.RoyalEnfield;
import com.examples.beans.xmls.postprocess.Tesla;

public class ExampleFirstApp {

	
	
	static {
		ExamplAppXmlConfig.configure();
	}
	
	public static void main(String[] args) {
		
		Department dept = ExamplAppXmlConfig.lookupBean(Department.class);
		dept.getSubjectMappings().forEach((k,v) ->{ System.out.println("Subject >>"+k.getName());
		                                            System.out.println("Teacher >>"+v.getName());});
		dept.getRooms().stream().forEach(r -> System.out.println("Room >>"+r.getName()));
		dept.getRooms().stream().forEach(r -> System.out.println("dept >>"+r.getDept().getName()));
		dept.getStudents().forEach(s -> System.out.println("student >>"+s.getName()));
		dept.getYears().forEach((k ,v) -> {System.out.println(k +"::" +v);});
		dept.getMailids().forEach((k ,v) -> {System.out.println(k +"::" +v);});
		
		
		///Lazy and Auto wire
		
		Book book = ExamplAppXmlConfig.lookupBeanByName("java-headfirst", Book.class);
		Book initByType = ExamplAppXmlConfig.lookupBeanByName("java-headfirstJsp", Book.class);
		Book book2 = ExamplAppXmlConfig.lookupBeanByName("java-headfirstDesign", Book.class);
		Book initbycons = ExamplAppXmlConfig.lookupBeanByName("java-script-definitiveguide", Book.class);
		
		//Method injection
		
		CommandManager manager = ExamplAppXmlConfig.lookupBean(CommandManager.class);
		CommandManager manager1 = ExamplAppXmlConfig.lookupBean(CommandManager.class);
		
		manager.callCommand("Command 1");
		manager.callCommand("Command 2");
		
		//Bean life cycle
		
		DemoBeanLifeCycle lifeCyle = ExamplAppXmlConfig.lookupBeanByName("lifecycleBean", DemoBeanLifeCycle.class);
		
		DemoBeanOverridedLifeCycle lifeCycle1 = ExamplAppXmlConfig.lookupBeanByName("lifecycleBean1", DemoBeanOverridedLifeCycle.class);
		
		
		// Factory bean and static Factory method 
		
		
       // Car car = ExamplAppXmlConfig.lookupBeanByName("audicar", Car.class);
        
        Audi q5 = ExamplAppXmlConfig.lookupBeanByName("caraudi", Audi.class);
        Audi q7 = ExamplAppXmlConfig.lookupBeanByName("caraudi", Audi.class);
        
        //Bike bike = ExamplAppXmlConfig.lookupBeanByName("royal-enfield", BikeFactory.class, RoyalEnfield.class);
        
     
		
		
		ExamplAppXmlConfig.close();
		
	}

}
