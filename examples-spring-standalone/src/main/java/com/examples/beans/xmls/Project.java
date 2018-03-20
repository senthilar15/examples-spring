package com.examples.beans.xmls;

import java.util.Arrays;
import java.util.List;

public class Project {
	
	private static  List<String> projects;
	
	static {
		
		projects = Arrays.asList(new String [] {"P1", "P2"});
		//System.out.println(projects);
	}
	
	public  List<String> findProjects(){
		return projects;
	}

}
