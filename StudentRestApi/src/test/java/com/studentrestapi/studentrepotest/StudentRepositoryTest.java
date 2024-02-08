package com.studentrestapi.studentrepotest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.studentrestapi.models.Student;
import com.studentrestapi.repository.StudentRepo;

//@DataJdbcTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTest {

//	@Autowired
//	private StudentRepo studentrepo;
//	
//	@Test
//	public void saveStudentTest() {
//		
//		Student student =new Student();
//		student.setFirstname("Shivangi");
//		student.setAddress("1100 Second Street East");
//		student.setStandard(13);
//		student.setEmail("gdhfjhg");
//		student.setGender("ghf");
//		student.setLastname("Bhavsar");
//		student.setPhoneno("476547566");
//		student.setRollno("6354");
//		
//		studentrepo.save(student);
//		Assertions.assertThat(student.getId()).isGreaterThan(0);
//	}
//	
}
