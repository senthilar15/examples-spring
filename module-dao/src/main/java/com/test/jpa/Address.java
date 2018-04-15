package com.test.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Address database table.
 * 
 */
@Entity
@Table(name="Address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private String county;
	private String province;
	private Timestamp stampDate;
	private String stampUser;
	private String state;
	private String streetName;
	private int zip;
	private Publication publication;

	public Address() {
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


	@Column(name="AddressLine1", length=500)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	@Column(name="AddressLine2", length=500)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	@Column(name="City", length=250)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="Country", length=250)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="County", length=250)
	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}


	@Column(name="Province", length=250)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
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


	@Column(name="State", length=250)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Column(name="StreetName", length=250)
	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	@Column(name="ZIP")
	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}


	//bi-directional one-to-one association to Publication
	@OneToOne(mappedBy="address", fetch=FetchType.LAZY)
	public Publication getPublication() {
		return this.publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}