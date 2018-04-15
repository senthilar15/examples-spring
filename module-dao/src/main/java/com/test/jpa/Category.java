package com.test.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.test.jpa.enums.CategoryTitle;
import com.test.jpa.lifecycle.DefaultRecordUpdateListener;


/**
 * The persistent class for the Category database table.
 * 
 */
@Entity
@Table(name="Category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
@EntityListeners({DefaultRecordUpdateListener.class })
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private CategoryTitle category;
	private String description;
	private int parent_Category;
	private Timestamp stampDate;
	private String stampUser;
	private Set<Book> books;

	public Category() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	/*@Column(name="Category", nullable=false, length=300)
	public String getCategory() {
		return this.category;
	}*/
	
	@Column(name="Category", nullable=false, length=300)
	public CategoryTitle getCategory() {
		return this.category;
	}
	
	

	public void setCategory(CategoryTitle category) {
		this.category = category;
	}


	@Column(name="Description", length=2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="Parent_Category")
	public int getParent_Category() {
		return this.parent_Category;
	}

	public void setParent_Category(int parent_Category) {
		this.parent_Category = parent_Category;
	}


	@Column(name="StampDate")
	public Timestamp getStampDate() {
		return this.stampDate;
	}

	public void setStampDate(Timestamp stampDate) {
		this.stampDate = stampDate;
	}


	@Column(name="StampUser", length=60)
	public String getStampUser() {
		return this.stampUser;
	}

	public void setStampUser(String stampUser) {
		this.stampUser = stampUser;
	}


	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="category")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setCategory(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setCategory(null);

		return book;
	}
	
}