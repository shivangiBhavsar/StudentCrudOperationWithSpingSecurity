package com.studentrestapi.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.models.Document;
import com.studentrestapi.repository.DocumentRepository;
import com.studentrestapi.service.DocumentService;


@Service
public class DocumentServiceImp implements DocumentService{
	
	@Autowired
	DocumentRepository documentrepository;

	@Override
	public Document saveDoc(MultipartFile file) {
		
		Document doc = new Document();
		doc.setDocname("studentimage");
		doc.setDoctype(file.getContentType());
		doc.setFilename(file.getOriginalFilename());
		doc.setSize(String.valueOf(file.getSize()));
		try {
			doc.setStudentimage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		doc = documentrepository.save(doc);
		return doc;
	}
	

}
