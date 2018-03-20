package com.examples.beans.xmls.lazy.auto;

import java.util.List;

public class Category {
	
	private int categoryId;
	private List<Book> books;
	
	
	public Category(int categoryId ) {
		this.categoryId = categoryId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
