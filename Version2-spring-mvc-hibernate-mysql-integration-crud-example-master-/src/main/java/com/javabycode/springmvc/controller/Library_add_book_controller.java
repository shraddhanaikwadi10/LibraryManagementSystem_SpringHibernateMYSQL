package com.javabycode.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.library_add_book_main;
import com.javabycode.springmvc.service.StudentService;


@Controller
@RequestMapping("/add_new_book.html")
public class Library_add_book_controller {
	
	@Autowired
	library_add_book_main addBookservice;

	@RequestMapping( method = RequestMethod.GET)
	public String add_bookPage(@Valid Book_details book_details,BindingResult result,
			ModelMap model) throws ParseException{	
		
	return "Add_new_book";
    }

	@RequestMapping(method = RequestMethod.POST)
	public String add_book(@ModelAttribute("book_details") Book_details book_details,BindingResult result,
			ModelMap model) throws ParseException
	{	
		String name= book_details.getBook_name();
		String  author=book_details.getBook_author();
		int Price= book_details.getBook_price();		
		String  Book_edition=book_details.getBook_edition();
		int pages = book_details.getPages();
		int ISBN = book_details.getISBN();
		String  language=book_details.getLanguage();
		
	//	String  Date_of_publish_get=(request.getParameter("date_of_publish")).toString();
	//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//	Date Date_of_publish = sdf.parse(Date_of_publish_get);
		Date Date_of_publish =book_details.getDate_of_publish();
		
		Boolean avalibility= true;
		
		library_add_book_main addbook= new library_add_book_main();
		addbook.add_db(name, author, Price,Book_edition,pages,language,Date_of_publish,avalibility,ISBN);
		//	ModelAndView mv= new ModelAndView();
	   // mv.setViewName("Addbookconfirmation.jsp");
		model.addAttribute("book_name",name);
		model.addAttribute("book_author", author);
		model.addAttribute("book_price", Price);
		model.addAttribute("ISBN", ISBN);
		model.addAttribute("Book_edition",Book_edition);
		model.addAttribute("pages", pages);
		model.addAttribute("language", language);
		//model.addAttribute("Date_of_publish", Date_of_publish);		
		//return mv;
	
		return "Addbookconfirmation";
}
	
	

}
