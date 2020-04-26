package com.javabycode.springmvc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.Student;
import com.javabycode.springmvc.model.User_details;

@Repository("UserDao")
public class UserDAOImpl extends AbstractDao<Integer, Student> implements UserDAO  {
	 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
	  @Resource(name="sessionFactory")
      protected SessionFactory sessionFactory;

      public void setSessionFactory(SessionFactory sessionFactory) {
             this.sessionFactory = sessionFactory;
      }
     
      protected Session getSession(){
             return sessionFactory.openSession();
      }
      
      public User_details getuserbyid(int id) throws ParseException
  	{
  		User_details user_details=new User_details();
  	
  		Session session = sessionFactory.openSession();
  		//boolean userFound = false;
  		//Query using Hibernate Query Language
  		//String SQL_QUERY =" select user_detai0_.User_ID as User_ID1_2_0_, user_detai0_.Address as Address2_2_0_, user_detai0_.Book1_ID as Book3_2_0_, user_detai0_.Book1_issue as Book4_2_0_, user_detai0_.Book1_return as Book5_2_0_, user_detai0_.Book2_ID as Book6_2_0_, user_detai0_.Book2_issue as Book7_2_0_, user_detai0_.Book2_return as Book8_2_0_, user_detai0_.User_name as User_nam9_2_0_, user_detai0_.active as active10_2_0_ from user_details user_detai0_ where user_detai0_.User_ID = :id";
  		String SQL_QUERY ="select User_name,Book1_ID,Book2_ID,Book1_issue,Book2_issue from user_details where User_ID='1'";
  		Query query = session.createQuery(SQL_QUERY);
  		
  		
  		List<Object[]> lists = query.list();
  		 
  		for (Object[] result: lists) {
  			
  			user_details.setBook1_ID(Integer.parseInt(result[1].toString()));
  			Date date2=formatter1.parse(result[3].toString()); 
  			user_details.setBook1_issue(date2);
  	
  			user_details.setBook2_ID(Integer.parseInt(result[2].toString()));
  		   Date date1=formatter1.parse(result[4].toString());  
  			user_details.setBook2_issue(date1);
  			
  			user_details.setUser_name(result[0].toString());
  			
  		}
  		//query.setParameter(0,userName);
  		//query.setParameter(1,userPassword);
  		//List list = query.list();
  		return user_details;
  		
  	
  	}

	@Override
	public ArrayList<Book_details> getBookByName(String bookName) throws ParseException {
		
	  	
  		Session session = sessionFactory.openSession();
  		String SQL_QUERY ="SELECT book.Book_ID,book.Book_name,book.Book_author,book.Book_price FROM Book_details as book where book.Book_name like '%"+bookName+"%'";
  		Query query = session.createQuery(SQL_QUERY);
  		
  		ArrayList<Book_details> booklist=new ArrayList<>();
  		List<Object[]> lists = query.list();
  		 
  		for (Object[] result: lists) {
  			Book_details book_details=new Book_details();
  			book_details.setBook_ID(Integer.parseInt(result[0].toString()));
  			book_details.setBook_name(result[1].toString());
  			book_details.setBook_author(result[2].toString());
  			book_details.setBook_price(Integer.parseInt(result[3].toString()));
  			
  			booklist.add(book_details);
  		}
  		
  		return booklist;
  		
	}
  	
	

}
