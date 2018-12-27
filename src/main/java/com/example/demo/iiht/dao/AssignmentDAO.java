package com.example.demo.iiht.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.iiht.dto.Book;
import com.example.demo.iiht.dto.Subject;

@Repository
@Transactional
public class AssignmentDAO {

	public static final Logger logger = LoggerFactory.getLogger(AssignmentDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

   
	public void addBook(Book book){
		entityManager.merge(book);
		
	}
	
	public void addSubject(Subject subject){
		entityManager.merge(subject);
		
	}
	
	public List<Object[]> searchBook(String title){
		Query query = entityManager.createQuery("Select b.bookId,b.title,b.price,b.volume,b.publishDate from Book b where b.title=?1");	
		query.setParameter(1, title);
		return query.getResultList();
	}
	
	public List<Object[]> searchSubject(String title){ 
		Query query = entityManager.createQuery("Select s.subjectId,s.subtitle,s.durationInHours,s.book.bookId from Subject s where s.subtitle=?1");	
		query.setParameter(1, title);
		return query.getResultList();
		
	}
	

	public List<Object[]> searchSubjectByDuration(int duration){ 
		Query query = entityManager.createQuery("Select s.subjectId,s.subtitle,s.durationInHours,s.book.bookId,s.book.title,s.book.price,s.book.volume,s.book.publishDate from Subject s where s.durationInHours=?1");	
		query.setParameter(1, duration);
		return query.getResultList();
		
	}
	
	public void deleteBook(String title){
		Query query = entityManager.createQuery("delete from Book b where b.title=?1");	
		query.setParameter(1, title);
		query.executeUpdate();
	}
	
	public void deleteSubject(String title){
		Query query = entityManager.createQuery("delete from Subject s where s.subtitle=?1");	
		query.setParameter(1, title);
		query.executeUpdate();
	}
	

}
