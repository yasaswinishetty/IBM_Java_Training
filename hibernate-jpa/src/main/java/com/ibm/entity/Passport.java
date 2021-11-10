package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private long passportNo;
	@Column(length=20)
	private String country;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Person citizen;

	public long getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(long passportNo) {
		this.passportNo = passportNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getCitizen() {
		return citizen;
	}

	public void setCitizen(Person citizen) {
		this.citizen = citizen;
	}

	
}
