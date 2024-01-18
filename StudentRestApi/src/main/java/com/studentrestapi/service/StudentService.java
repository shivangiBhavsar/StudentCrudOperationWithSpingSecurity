package com.studentrestapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.models.Student;
import com.studentrestapi.models.User;


public interface StudentService {

	public boolean addStudent(Student student);
	public List<Student> getAllStudents();
	public void deleteStudents(int id);
	public Student getStudentById(int id);
	public  void updateStudent(int id,Student student,MultipartFile file);
	
	public boolean studentExistsByUser(Long id);
	//public List<Student> findByUsername(String username);

}
