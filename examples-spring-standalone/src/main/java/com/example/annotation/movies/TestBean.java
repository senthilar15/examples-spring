package com.example.annotation.movies;

public class TestBean {
	
	private int age;
	private String beanScopeName;
	
	
	public TestBean(String beanScopeName) {
		this.beanScopeName = beanScopeName;
	}
	
	public TestBean(String beanScopeName, int age) {
		this(beanScopeName);
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setSpouse(TestBean spouse) {
		// TODO Auto-generated method stub
		
	}

	public void setCountry(String country) {
		// TODO Auto-generated method stub
		
	}

}
