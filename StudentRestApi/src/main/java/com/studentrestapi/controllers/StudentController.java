package com.studentrestapi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.jwt.JwtUtils;
import com.studentrestapi.models.Document;
import com.studentrestapi.models.Student;
import com.studentrestapi.models.User;
import com.studentrestapi.payload.response.MessageResponse;
import com.studentrestapi.payload.response.UserInfoResponse;
import com.studentrestapi.repository.UserRepository;
import com.studentrestapi.service.DocumentService;
import com.studentrestapi.service.StudentService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/rest")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private DocumentService documentservice;
	
	@Autowired
	private JwtUtils jwtutils;
	
	 @GetMapping("/user")
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	  public String userAccess() {
	    return "User Content.";
	  }
	
	@PostMapping(value = "/addstudent", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('USER') or hasRole('STUDENT')")
	public ResponseEntity<?> addStudent(
			@RequestPart("file") MultipartFile file,@Valid @RequestPart Student student,HttpServletRequest request) {
	String username =jwtutils.getUserNameFromJwtToken(request.getCookies()[0].getValue());
	 Optional<User> user = userRepository.findByUsername(username);
//	 if (studentservice.studentExistsByUser(user.get().getId())) {
//	      return ResponseEntity.badRequest().body(new MessageResponse("Error: student is already exist!"));
//	    }
	    student.setuId(user.get().getId());
			if (file.getSize() > 0) {
				Document doc = documentservice.saveDoc(file);
				student.setDocument(doc);
				}
		studentservice.addStudent(student);
		return ResponseEntity.ok().body(student);
	}
	
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok().body(studentservice.getAllStudents());
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<?> studentStudent(@PathVariable int id) {
		studentservice.deleteStudents(id);
		return ResponseEntity.ok().body(studentservice.getAllStudents());
	}
	
	@PostMapping(value ="/updateStudent/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('USER') or hasRole('STUDENT')")
	public ResponseEntity<?> updateStudent(@RequestPart("file") MultipartFile file,@RequestPart Student student,@PathVariable int id) {
		studentservice.updateStudent(id, student,file);
		return ResponseEntity.ok().body(student);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
	
}
