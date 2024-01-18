package com.studentrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String filename;
	
	@Column
	private String doctype;
	
	@Column
	private String docname;
	
	@Column
	private String size;
	
	@Lob
	@Column(name = "studentimage", columnDefinition="LONGBLOB")
	@JsonIgnore
	private byte[] studentimage;
	
	@OneToOne(mappedBy = "document")
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public byte[] getStudentimage() {
		return studentimage;
	}

	public void setStudentimage(byte[] studentimage) {
		this.studentimage = studentimage;
	}


	
	
	
	
}
