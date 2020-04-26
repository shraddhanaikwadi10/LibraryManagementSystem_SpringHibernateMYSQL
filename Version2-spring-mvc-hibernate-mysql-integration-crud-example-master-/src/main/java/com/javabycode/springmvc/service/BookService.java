package com.javabycode.springmvc.service;

import java.text.ParseException;
import java.util.ArrayList;

import com.javabycode.springmvc.model.Book_details;

public interface BookService {
	
	public ArrayList<Book_details> getBookByName(String bookName) throws ParseException;

}
