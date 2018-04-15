package com.test.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the Publication database table.
 * 
 */
@Entity
@Table(name="Publication")
@NamedQuery(name="Publication.findAll", query="SELECT p FROM Publication p")
public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String publicationName;
	private Timestamp stampDate;
	private String stampUser;
	private Set<Book> books;
	private Address address;
	private Book book;

	public Publication() {
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


	@Column(name="PublicationName", nullable=false, length=300)
	public String getPublicationName() {
		return this.publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
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
	@OneToMany(mappedBy="publication")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setPublication(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setPublication(null);

		return book;
	}


	//bi-directional one-to-one association to Address
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Address_Id", nullable=false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	//bi-directional many-to-one association to Book
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_Id", nullable=false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}