package com.javabycode.springmvc.controller;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.service.BookService;


@Controller
@RequestMapping("/Search_book.html")
public class View_by_id {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping( method = RequestMethod.GET)
	public String search_bookPage(@Valid Book_details book_details,BindingResult result,
			ModelMap model)
	{	
	
		return "Search_by_ID_home";
	}


	@RequestMapping( method = RequestMethod.POST)
	public String search_book( @RequestParam("book_name") String book_name,
			ModelMap model) throws ParseException
	{	
		Book_details book = new Book_details();
		//int book_ID= book_details.getBook_ID();
		//int book_ID1= book_ID;
		String bookName= book_name;
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		//book= (Book_details) session.get(Book_details.class, bookName);
		ArrayList<Book_details> booklist=new ArrayList<>();
		booklist=bookService.getBookByName(bookName);
		
		int book_id= book.getBook_ID();
		String book_Name= book.getBook_name();
		String book_author= book.getBook_author();
		int price= book.getBook_price();
		//ModelAndView mv= new ModelAndView();
		//mv.setViewName("view_by_ID_serch_result.jsp");
		/*model.addAttribute("book_id",book_id);
		model.addAttribute("book_name",book_Name);
		model.addAttribute("book_author", book_author);
		model.addAttribute("book_price", price);	*/
		
	    model.addAttribute("list", booklist);

		//return mv;
		if(booklist.size()!=0) {
		return "view_by_ID_serch_result";
		}
		else {
			return "book_not_available";
		}
	}

	
}
