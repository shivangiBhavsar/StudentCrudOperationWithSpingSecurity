package com.studentrestapi.service;

import org.springframework.web.multipart.MultipartFile;

import com.studentrestapi.models.Document;


public interface DocumentService {

	public Document saveDoc(MultipartFile file);
}
