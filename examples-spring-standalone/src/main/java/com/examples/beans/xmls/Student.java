package com.examples.beans.xmls;

public class Student {
	
	private String name;
	private int rollNo;
	private Department department;
	
	public Student(String name , int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student)obj;
			return this.name.equalsIgnoreCase(s.name);
		}
		return false;
	}
	
	

}
