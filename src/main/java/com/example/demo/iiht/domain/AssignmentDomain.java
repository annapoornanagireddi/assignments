package com.example.demo.iiht.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.iiht.dao.AssignmentDAO;
import com.example.demo.iiht.dto.Book;
import com.example.demo.iiht.dto.Subject;

@Component
public class AssignmentDomain {
	
	@Autowired
	AssignmentDAO assignmentDAO;
	public String addBook(Book book){
		//book.setPublishDate(formateDate(book.getPublishDate(),"mm-dd-yyyy"));
		assignmentDAO.addBook(book);
		String status = "Success";
		return status;
	}
	
	public static Date formateDate(String date, String dtformat) throws ParseException {
		if (null != date && !date.isEmpty()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dtformat);
			return dateFormat.parse(date);
		}
		return null;
	}
	
	public String addSubject(Subject subject){
		assignmentDAO.addSubject(subject);
		String status = "Success";
		return status;
	}
	
	public String deleteBook(String title){
		assignmentDAO.deleteBook(title);
		String status = "Success";
		return status;
	}
	
	public String deleteSubject(String title){
		assignmentDAO.deleteSubject(title);
		String status = "Success";
		return status;
	}
	
	public Book searchBook(String title) throws ParseException{
		Book book = new Book();
		List<Object[]> objList = assignmentDAO.searchBook(title);
		for(Object[] obj: objList){
		book.setBookId(Integer.parseInt(obj[0].toString().trim()));
		book.setTitle(obj[1].toString().trim());
		book.setPrice(Double.parseDouble(obj[2].toString().trim()));
		book.setVolume(Integer.parseInt(obj[3].toString().trim()));
		book.setPublishDate(convertStringToDate(obj[4].toString().trim()));
		}
		return book;
	}
	
	public Subject searchSubject(String title){
		Subject subject = new Subject();
		List<Object[]> objList = assignmentDAO.searchSubject(title);
		for(Object[] obj: objList){
			Book book = new Book();
			subject.setSubjectId(Integer.parseInt(obj[0].toString().trim()));
			subject.setSubtitle(obj[1].toString().trim());
			subject.setDurationInHours(Integer.parseInt(obj[2].toString().trim()));
			book.setBookId(Integer.parseInt(obj[3].toString().trim()));
			subject.setBook(book);
		}
		return subject;
	}
	
	public Subject searchSubjectByDuration(int duration){
		Subject subject = new Subject();
		List<Object[]> objList = assignmentDAO.searchSubjectByDuration(duration);
		for(Object[] obj: objList){
			Book book = new Book();
			subject.setSubjectId(Integer.parseInt(obj[0].toString().trim()));
			subject.setSubtitle(obj[1].toString().trim());
			subject.setDurationInHours(Integer.parseInt(obj[2].toString().trim()));
			book.setBookId(Integer.parseInt(obj[3].toString().trim()));
			book.setTitle(obj[4].toString().trim());
			book.setPrice(Double.parseDouble(obj[5].toString().trim()));
			book.setVolume(Integer.parseInt(obj[6].toString().trim()));
			try {
				book.setPublishDate(convertStringToDate(obj[7].toString().trim()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			subject.setBook(book);
		}
		return subject;
	}

	public Date convertStringToDate(String date) throws ParseException {
		Date date1 = new SimpleDateFormat("yyyy-dd-MM").parse(date);
		return date1;
	}
}
