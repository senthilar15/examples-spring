package com.examples.beans.xmls.lazy.auto;

import org.springframework.beans.factory.annotation.Qualifier;

public class Book {

	private String name;
	private int noOfPages;
	private Category category;
	private Publication publication;
	private Author author;
	
	public Book(String name , int noOfPages) {
		this.name = name;
		this.noOfPages = noOfPages;
		System.out.println("Book :: name >> "+name+"  Initilaized through Book(String name , int noOfPages)");
	}
	
	public Book(@Qualifier("author") Author author) {
		this.author = author;
		System.out.println("Initilaized through Book(Author author))");
	}
	/*
	public Book() {
	
		System.out.println("Initilaized through Book())");
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
		System.out.println("Book :: name >> "+name+" Initilaized through byName setCategory(Category category) ");
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
		System.out.println("Book :: name >> "+name+" Initilaized through byType setPublication(Publication publication)");
	}
	
	
	
	
}
