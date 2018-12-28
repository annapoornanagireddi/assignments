package com.example.demo.iiht.service;

import java.text.ParseException;
import java.util.List;

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
	private AssignmentDomain assignmentDomain;
	
	public String addBook(Book book){
		String status = assignmentDomain.addBook(book);
		return status;
	}
	
	public String updateBook(Book book){
		String status = assignmentDomain.updateBook(book);
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
	
	public String deleteBookById(long bookId){
		String status = assignmentDomain.deleteBookById(bookId);
		return status;
	}
	
	public String deleteSubject(String title){
		String status = assignmentDomain.deleteSubject(title);
		return status;
	}
	
	
	public List<Book> searchBook(String title) throws ParseException{
		List<Book> books = assignmentDomain.searchBook(title);
		return books;
	}
	
	public List<Book> searchBookById(long bookId) throws ParseException{
		List<Book> books = assignmentDomain.searchBookById(bookId);
		return books;
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
