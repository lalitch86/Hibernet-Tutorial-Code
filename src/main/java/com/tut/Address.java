package com.tut;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {
	@Id // primary column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "street_id")
	private int addressid;
	@Column(length = 50, name = "STREET")
	private String street;
	@Column(length = 50, name = "CITY")
	private String City;
	@Column(name = "is_open")
	private boolean open;
	@Transient // if not want to add column in database
	private double x;
	@Column(name = "added_date")
	@Temporal(TemporalType.DATE) // date formate
	private Date addDate;
	@Lob // for identify large objects
	private byte[] image;

	public int addressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressid, String street, String city, boolean open, double x, Date addDate, byte[] image) {
		super();
		this.addressid = addressid;
		this.street = street;
		City = city;
		this.open = open;
		this.x = x;
		this.addDate = addDate;
		this.image = image;
	}

}
