package com.javabycode.springmvc.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabycode.springmvc.dao.StudentDao;
import com.javabycode.springmvc.dao.UserDAO;
import com.javabycode.springmvc.service.StudentService;


public class Add_user_main {


		@Autowired
		private UserDAO dao;
	
	public void add_user_db(String user_name, String Address, int Book1_ID,
			Date Book1_issue,Date Book1_return,int Book2_ID,Date Book2_issue,Date Book2_return )
	{
		
		User_details user= new User_details();
		user.setUser_name(user_name);
		user.setAddress(Address);
		user.setBook1_ID(Book1_ID);
		user.setBook1_issue(Book1_issue);
		user.setBook1_return(Book1_return);
		user.setBook2_ID(Book2_ID);
		user.setBook2_issue(Book2_issue);
		user.setBook1_return(Book2_return);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	   user=null;
	}
		
	public void add_user_db(User_details user_details)
	{
		
		User_details user= new User_details();
		user.setUser_name(user.getUser_name());
		user.setAddress(user.getAddress());
		user.setBook1_ID(user.getBook1_ID());
		user.setBook1_issue(user.getBook1_issue());
		user.setBook1_return(user.getBook1_return());
		user.setBook2_ID(user.getBook2_ID());
		user.setBook2_issue(user.getBook2_issue());
		user.setBook1_return(user.getBook1_return());
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	    //user=null;
	}	

	public User_details getuserbyid(int id) throws ParseException {
		return dao.getuserbyid(id);
	}
}
