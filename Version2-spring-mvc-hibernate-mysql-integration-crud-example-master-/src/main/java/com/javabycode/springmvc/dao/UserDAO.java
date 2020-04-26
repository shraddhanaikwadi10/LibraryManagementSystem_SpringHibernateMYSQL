package com.javabycode.springmvc.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.User_details;

public interface UserDAO {

	 User_details getuserbyid(int id) throws ParseException;
	 
	 ArrayList<Book_details> getBookByName(String bookName) throws ParseException;
	
}
