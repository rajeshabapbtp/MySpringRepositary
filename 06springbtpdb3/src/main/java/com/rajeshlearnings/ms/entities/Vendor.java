package com.rajeshlearnings.ms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Component
@Entity
@Table(name="vendor2")
public class Vendor {

	@Id
	@Column(nullable=false, name="Id")
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="uuid")
	private String code;
	@Column(nullable=false, name="company_name")
	private String companyName;
	@Column(nullable=false, name="contact_person")
	private String contactPersion;
	@Column(nullable=false, name="first_name")
	private String firstName;
	@Column(nullable=true, name="last_name")
	private String lastName;
	@Column(nullable=true, name="website")
	private String website;
	@Column(nullable=true, name="email")
	private String email;
	@Column(nullable=false, name="status")
	private String status;
	@Column(nullable=false, name="reg_date")
	private Date regDate;
	
	
	//Link with Address
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)	
	@JoinColumn(name = "vendor_id", referencedColumnName = "Id")
	private List<Address> addressess = new ArrayList<>();
	
	// Setter & Getter for Adddressess. This Seetter & Getter methods are important for association between
	// Vendor and Address tables
	
	public List<Address> getAddressess() {
		return addressess;
	}
	public void setAddressess(List<Address> addressess) {
		this.addressess = addressess;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPersion() {
		return contactPersion;
	}
	public void setContactPersion(String contactPersion) {
		this.contactPersion = contactPersion;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	
	
	public Vendor() {
//		super();
//		this.code = "Vendor1";
//		this.companyName = "ABC Company";
//		this.contactPersion = "Sarat";
//		this.firstName = "Mukhesh";
//		this.lastName = "Ambani";
//		this.website = "relience.com";
//		this.email = "mukesh@jio.com";
//		this.status = "Active";
//		this.regDate = new Date();
	}
	
	
	
	public Vendor(String code, String companyName, String contactPersion, String firstName, String lastName,
			String website, String email, String status, Date regDate) {
		super();
		this.code = code;
		this.companyName = companyName;
		this.contactPersion = contactPersion;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Vendor [code=" + code + ", companyName=" + companyName + ", contactPersion=" + contactPersion
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", website=" + website + ", email=" + email
				+ ", status=" + status + ", regDate=" + regDate + "]";
	}	
	
}
