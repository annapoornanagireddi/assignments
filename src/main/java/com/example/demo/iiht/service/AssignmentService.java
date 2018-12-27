package com.example.demo.iiht.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.iiht.domain.AssignmentDomain;
import com.example.demo.iiht.dto.Book;
import com.example.demo.iiht.dto.Subject;

@Service
@Transactional
public class AssignmentService {
	
	@Autowired
	AssignmentDomain assignmentDomain;
	
	public String addBook(Book book){
		String status = assignmentDomain.addBook(book);
		return status;
	}
	
	public String addSubject(Subject subject){
		String status = assignmentDomain.addSubject(subject);
		return status;
	}
	
	public String deleteBook(String title){
		String status = assignmentDomain.deleteBook(title);
		return status;
	}
	
	public String deleteSubject(String title){
		String status = assignmentDomain.deleteSubject(title);
		return status;
	}
	
	
	public Book searchBook(String title) throws ParseException{
		Book book = assignmentDomain.searchBook(title);
		return book;
	}
	
	public Subject searchSubject(String title){
		Subject subject = assignmentDomain.searchSubject(title);
		return subject;
	}
	
	public Subject searchSubjectByDuration(int duration){
		Subject subject = assignmentDomain.searchSubjectByDuration(duration);
		return subject;
	}
}
