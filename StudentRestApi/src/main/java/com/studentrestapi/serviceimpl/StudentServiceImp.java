package com.studentrestapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.Util.Dates;
import com.studentrestapi.models.Document;
import com.studentrestapi.models.Student;
import com.studentrestapi.repository.StudentRepo;
import com.studentrestapi.service.DocumentService;
import com.studentrestapi.service.StudentService;

@Service(value = "studentService")
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepo studentrepo;

	@Autowired
	private DocumentService documentservice;

	@Override
	public boolean addStudent(Student student) {
		student.setCreatedate(Dates.getCurrentDate());
		student = studentrepo.save(student);
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentrepo.findAll();
	}

	@Override
	public void deleteStudents(int id) {
		studentrepo.deleteById(id);

	}

	@Override
	public Student getStudentById(int id) {
		return studentrepo.findById(id);
	}

	@Override
	public void updateStudent(int id, Student student, MultipartFile file) {
		Student oldStudent = studentrepo.findById(id);
		oldStudent.setModifydate(Dates.getCurrentDate());
		if (file.getSize() > 0) {
			Document doc = documentservice.saveDoc(file);
			oldStudent.setDocument(doc);
		}
		oldStudent = changeUpdatedvalue(oldStudent, student);
		studentrepo.save(oldStudent);
	}
	

	@Override
	public boolean studentExistsByUser(Long id) {
		// TODO Auto-generated method stub
		Long f = studentrepo.studentExistsByUser(id);
		if (f > 0) {
			return true;
		} else {
			return false;
		}

	}

	private Student changeUpdatedvalue(Student oldstudent, Student newstudent) {
		oldstudent.setFirstname(newstudent.getFirstname());
		oldstudent.setLastname(newstudent.getLastname());
		oldstudent.setEmail(newstudent.getEmail());
		oldstudent.setRollno(newstudent.getRollno());
		oldstudent.setPhoneno(newstudent.getPhoneno());
		oldstudent.setGender(newstudent.getGender());
		oldstudent.setStandard(newstudent.getStandard());
		oldstudent.setAddress(newstudent.getAddress());
		return oldstudent;
	}


//	@Override
//	public boolean addStudent(Student student) {
//		//String pass="";
//		student.setCreatedate(Dates.getCurrentDate());
////		if(student.getId()==0) {
////		//	String username=GenerateUnique.convertToUniqueUsername(student.getFirstname(),studentservice);
////			
////			//student.setUsername(username);
////		//	 pass=GenerateUnique.passwordGenerate();
////			 System.out.println("pass:"+pass);
////			//student.setPassword(bcryptEncoder.encode(pass));
////			student.setCreatedate(Dates.getCurrentDate());
////		}else {
////			student.setModifydate(Dates.getCurrentDate());
////		}
//		student=studentrepo.save(student);
//		return true;
//		
//		// send email to student for their username and password for login student portal
//		//boolean result= emailservice.sendUsernameAndPassword(student,pass);
////		if(result) {
////			student=studentrepo.save(student);
////			return true;
////		}
//		
//		//return false;
//	}

}
