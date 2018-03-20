package com.examples.beans.xmls;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Department {
	
	private String name;
	private List<ClassRoom> rooms;
	private Map<Subject, Teacher> subjectMappings;
	private Properties years; 
	private Set<Student> students;
	private Set<Teacher> teachers;
	private Properties mailids; 
	
	public Department(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClassRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<ClassRoom> rooms) {
		this.rooms = rooms;
	}

	public Map<Subject, Teacher> getSubjectMappings() {
		return subjectMappings;
	}

	public void setSubjectMappings(Map<Subject, Teacher> subjectMappings) {
		this.subjectMappings = subjectMappings;
	}

	public Properties getYears() {
		return years;
	}

	public void setYears(Properties years) {
		this.years = years;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Properties getMailids() {
		return mailids;
	}

	public void setMailids(Properties mailids) {
		this.mailids = mailids;
	}
	
	
	
	

}
