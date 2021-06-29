package com.sp.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cricketers")
public class Cricketer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="email_id")
	private String emailId;
	
	@Column(name = "country")
	private String country;
	
	@Column(name ="role")
	private String role;
	
	@Column(name ="is_retired")
	private String isRetired;
	
	@Column(name ="profile_link")
	private String profileLink;
	
	
	
	public Cricketer()
	{
		
	}
	
	
	public Cricketer(String firstName, String lastName, String emailId, String country, String role, String isRetired,
			String profileLink) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.country = country;
		this.role = role;
		this.isRetired = isRetired;
		this.profileLink = profileLink;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsRetired() {
		return isRetired;
	}


	public void setIsRetired(String isRetired) {
		this.isRetired = isRetired;
	}


	public String getProfileLink() {
		return profileLink;
	}

	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
