package com.examples.beans.xmls.lazy.auto;

import java.util.List;

public class Author {
	
	private int authorId;
	private String authorName;
	private List<Book> books;
	
	public Author(int authorId, String authorName) {
		
		this.authorId = authorId;
		this.authorName = authorName;
		System.out.println("Initialized Author");
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	

}
