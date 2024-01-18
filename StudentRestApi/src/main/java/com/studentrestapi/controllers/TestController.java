package com.studentrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.models.Document;
import com.studentrestapi.models.Student;
import com.studentrestapi.service.DocumentService;
import com.studentrestapi.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
// for Angular Client (withCredentials)
// @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	public StudentService studentservice;
	
	@Autowired
	public DocumentService documentservice;
	
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }
  
  @PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addstudent")
	public List<Student> addStudent(@RequestParam("file") MultipartFile file,@RequestBody Student student) {
		if(student.getId()!=0) {
			if (file.getSize() > 0) {
				Document doc = documentservice.saveDoc(file);
				student.setDocument(doc);
			}else {
			student.setDocument(studentservice.getStudentById(student.getId()).getDocument());
			}
		}
		studentservice.addStudent(student);
		return studentservice.getAllStudents();
	}
	
//  @GetMapping("/student")
//  @PreAuthorize("hasRole('USER')")
//  public String addStudent() {
//    return "add student.";
//  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
