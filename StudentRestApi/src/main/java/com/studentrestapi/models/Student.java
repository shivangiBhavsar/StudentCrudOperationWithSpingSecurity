package com.studentrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studentrestapi.CustomAnnotation.ValidateStandardOfStudent;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Firstname is mandatory")
	@Column
	private String firstname;
	
	@NotBlank(message = "Lastname is mandatory")
	@Column
	private String lastname;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Invalid email format")
	@Column
	private String email;
	
	@NotBlank(message = "Rollno is mandatory")
	@Column
	private String rollno;
	
	@NotBlank(message = "PhoneNo is mandatory")
	@Column
	private String phoneno;
	
	@NotBlank(message = "Gender is mandatory")
	@Column
	private String gender;
	
	//custom annotation
	//@NotBlank(message = "Standard is mandatory")
	@ValidateStandardOfStudent
	@Column
	private Integer standard;
	
	@Column
	private String createdate;
	@Column
	private String modifydate;
	
	@NotBlank(message = "Address is mandatory")
	@Column(columnDefinition = "TEXT")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_id", referencedColumnName = "id")
	private Document document;
	
	@Column(name = "uId", unique = false)
	private Long uId;
	

	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	@JsonIgnore
//	public User user;
//	
//	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	
	
	
}
