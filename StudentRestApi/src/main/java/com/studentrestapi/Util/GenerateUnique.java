package com.studentrestapi.Util;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.studentrestapi.models.Student;
import com.studentrestapi.service.StudentService;


public class GenerateUnique implements IdentifierGenerator{
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		 String key = (String) UUID.randomUUID().toString().subSequence(0, 10);
		 return key;
	}
	
	public static String passwordGenerate() {
		return (String) UUID.randomUUID().toString().subSequence(0, 10);
		
	}
	

//	    public static String convertToUniqueUsername(String name,StudentService studentservice) {
//	        // Normalize the name to remove diacritics (accents)
//	        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
//
//	        // Remove non-ASCII characters
//	        String asciiOnly = normalized.replaceAll("[^\\p{ASCII}]", "");
//
//	        // Replace spaces with underscores and convert to lowercase
//	        String baseUsername = asciiOnly.replaceAll("\\s", "_").toLowerCase();
//
//	        // Ensure uniqueness by appending numbers if necessary
//	        String uniqueUsername = baseUsername;
//	        
//	        
//	      //List<Student> student=studentservice.findByUsername(uniqueUsername);
//	        
//	      if(student.size()>0) {
//	        int counter = 1;
//	        while (student.contains(uniqueUsername)) {
//	            uniqueUsername = baseUsername + counter;
//	            counter++;
//	        }
//	      }
//	        // Add the unique username to the set of existing usernames
//	        
//
//	        return uniqueUsername;
//	    }
	
}
