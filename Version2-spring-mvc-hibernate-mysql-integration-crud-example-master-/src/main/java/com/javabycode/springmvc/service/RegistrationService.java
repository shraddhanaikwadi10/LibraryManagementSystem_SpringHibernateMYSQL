package com.javabycode.springmvc.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.Registration;
import com.javabycode.springmvc.model.Users;

public class RegistrationService {
	
	public void add_UserRegistrationData(Registration registration)
	{
	Users users = new Users();
	users.setId(registration.getId());
	users.setUserName(registration.getUserName());
	users.setUserPassword(registration.getPassword());
	users.setEmail(registration.getEmail());
	
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionfactory.openSession();
	session.beginTransaction();
	session.save(users);
	session.getTransaction().commit();
	session.close();
  //  book= null;
	}

}
