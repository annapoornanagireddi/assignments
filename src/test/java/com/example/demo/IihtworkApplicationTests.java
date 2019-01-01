package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.iiht.dto.Book;
import com.example.demo.iiht.service.AssignmentService;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class IihtworkApplicationTests {
	@Test
	public void contextLoads() {
	}
	private Book book;
	 @Test
	   public void addBookTest() {
		 book = new Book();
		 book.setBookId(10043);
		 book.setTitle("PYTHON");
		 book.setPrice(500);
		 book.setVolume(5);
		 try {
			book.setPublishDate(convertStringToDate("2019-10-10"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 AssignmentService mock = org.mockito.Mockito.mock(AssignmentService.class);
	      Mockito.when(mock.addBook(book)).thenReturn("Book added succesfully");
	      Assert.assertEquals("PYTHON",book.getTitle());
	   }
	 
	 public Date convertStringToDate(String date) throws ParseException {
			Date date1 = new SimpleDateFormat("yyyy-dd-MM").parse(date);
			return date1;
		}

}

