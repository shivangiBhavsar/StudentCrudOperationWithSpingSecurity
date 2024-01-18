package com.studentrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentrestapi.models.Document;



@Repository
public interface DocumentRepository  extends CrudRepository<Document, Integer>{

	Document save(Document doc);
}
