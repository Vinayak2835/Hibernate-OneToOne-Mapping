package com.login.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserProfile {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String phoneNumber;
	private String address;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
	private User user;

	public UserProfile(long id, String phoneNumber, String address, Gender gender, LocalDate dob, User user) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.user = user;
	}

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", phoneNumber=" + phoneNumber + ", address=" + address + ", gender=" + gender
				+ ", dob=" + dob + ", user=" + user + "]";
	}

}
