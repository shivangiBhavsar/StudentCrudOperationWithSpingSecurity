package com.studentrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentrestapi.models.Student;
import com.studentrestapi.models.User;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	//public List<Student> addStudent(Student student);
	
	Student save(Student student);
	List<Student> findAll();
	Student findById(int id);
	 
	@Query(value = "SELECT COUNT(*) FROM Student s WHERE s.user_id = :userId", nativeQuery = true)
    Long studentExistsByUser(@Param("userId") Long userId);
	//boolean studentExistsByUser(Long id);
	//public List<Student> findByUsername(String username);
}
