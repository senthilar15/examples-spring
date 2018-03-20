package com.examples.beans.xmls;

public class Teacher {
	
	private Subject subject;
	private String name;
	private int employeeNo;
	
	public Teacher(Subject subject , String name) {
		this.subject = subject;
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	
	
	

}
