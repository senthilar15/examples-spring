package com.test.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Review database table.
 * 
 */
@Entity
@Table(name="Review")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private short ratings;
	private String reviewComment;
	private Timestamp stampDate;
	private String stampUser;
	private Book book;

	public Review() {
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


	@Column(name="Ratings")
	public short getRatings() {
		return this.ratings;
	}

	public void setRatings(short ratings) {
		this.ratings = ratings;
	}


	@Column(name="ReviewComment", nullable=false, length=2000)
	public String getReviewComment() {
		return this.reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Book_Id", nullable=false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}