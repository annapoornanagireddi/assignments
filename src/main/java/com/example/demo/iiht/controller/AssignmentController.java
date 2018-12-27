package com.example.demo.iiht.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.iiht.dto.Book;
import com.example.demo.iiht.dto.Subject;
import com.example.demo.iiht.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

	public static final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

	@Autowired
	private AssignmentService assignmentService;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addBook(@RequestBody Book book){
		String status = assignmentService.addBook(book);
		return status;
	}
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addSubject(@RequestBody Subject subject){
		String status = assignmentService.addSubject(subject);
		return status;
	}
	

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteBook(@RequestParam String title){
		String status = assignmentService.deleteBook(title);
		return status;
	}
	
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteSubject(@RequestParam String title){
		String status = assignmentService.deleteSubject(title);
		return status;
	}
	

	@RequestMapping(value = "/searchBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book searchBook(@RequestParam String title) throws ParseException{
		Book book = assignmentService.searchBook(title);
		return book;
	}
	
	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Subject searchSubject(@RequestParam String title){
		Subject subject = assignmentService.searchSubject(title);
		return subject;
	}
	

	@RequestMapping(value = "/searchSubjectByDuration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Subject searchSubjectByDuration(@RequestParam int duration){
		Subject subject = assignmentService.searchSubjectByDuration(duration);
		return subject;
	}

}
