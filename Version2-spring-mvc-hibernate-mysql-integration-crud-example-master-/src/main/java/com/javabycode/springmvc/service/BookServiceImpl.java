package com.javabycode.springmvc.service;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabycode.springmvc.dao.LoginDAO;
import com.javabycode.springmvc.dao.UserDAO;
import com.javabycode.springmvc.model.Book_details;

@Service("BookService")
public class BookServiceImpl implements BookService{
	 @Autowired
	 private UserDAO userDAO;

	@Override
	public ArrayList<Book_details> getBookByName(String bookName) throws ParseException {
		// TODO Auto-generated method stub
		return userDAO.getBookByName(bookName);
	}

}
