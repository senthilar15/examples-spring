package com.examples.beans.xmls.lazy.auto;

import java.util.List;

public class Publication {
	
	private int publicationId;
	private String publicationName;
	private List<Book> publishedBooks;
	
	public Publication(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public List<Book> getPublishedBooks() {
		return publishedBooks;
	}

	public void setPublishedBooks(List<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}
	
}
