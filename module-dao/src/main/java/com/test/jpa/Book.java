package com.test.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the Book database table.
 * 
 */
@Entity
@Table(name="Book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private int noOfPages;
	private Timestamp stampDate;
	private String stampUser;
	private String title;
	private Set<Author> authors;
	private Author author;
	private Category category;
	private Publication publication;
	private Set<Publication> publications;
	private Set<Review> reviews;

	public Book() {
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


	@Column(name="Description", length=2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="NoOfPages", nullable=false)
	public int getNoOfPages() {
		return this.noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
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


	@Column(name="Title", nullable=false, length=250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(
		name="Book_Author"
		, joinColumns={
			@JoinColumn(name="Book_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="Author_id", nullable=false)
			}
		)
	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}


	//bi-directional many-to-one association to Author
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Author_Id", nullable=false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Category_Id", nullable=false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-one association to Publication
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Id", referencedColumnName="Book_Id", nullable=false, insertable=false, updatable=false)
	public Publication getPublication() {
		return this.publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}


	//bi-directional many-to-one association to Publication
	@OneToMany(mappedBy="book")
	public Set<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	public Publication addPublication(Publication publication) {
		getPublications().add(publication);
		publication.setBook(this);

		return publication;
	}

	public Publication removePublication(Publication publication) {
		getPublications().remove(publication);
		publication.setBook(null);

		return publication;
	}


	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="book")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setBook(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setBook(null);

		return review;
	}

}