package com.javabycode.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.User_details;

@RequestMapping("/issue_book_home.html")
@Controller
public class issue_book_controller {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showIssueBookPage(ModelMap model) {
		//User_details user_details = new User_details();
	//	model.put("user_details", user_details);

	    model.addAttribute("user_details", new User_details()); 
	    model.addAttribute("book_details", new Book_details()); 
		return "issue_book_home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String issue_book(@RequestParam("user_ID") int user_ID,
			@RequestParam("book_ID") int book_ID,@RequestParam("date_of_issue") String date_of_issue,
			ModelMap model) throws ParseException{	
		
	//	ModelAndView mv= new ModelAndView();
	//	mv.setViewName("issue_book_confirmation.jsp");
	//	ModelAndView mv_limit_excced= new ModelAndView();
	//	mv_limit_excced.setViewName("issue_book_limit.jsp");
	//	ModelAndView mv_book_not_avalible= new ModelAndView();
	//	mv_book_not_avalible.setViewName("book_not_avalible.jsp");
		Book_details book = new Book_details();
		User_details user = new User_details();
		
		//int User_ID= Integer.parseInt(request.getParameter("user_ID"));
	//	int Book_ID= Integer.parseInt(request.getParameter("book_ID"));
		
		int User_ID= user_ID;
		int Book_ID= book_ID;
		
	//	String  Date_of_issue_get=(request.getParameter("date_of_issue")).toString();
		String  Date_of_issue_get=date_of_issue;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date_of_issue1 = sdf.parse(Date_of_issue_get);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session= sessionfactory.openSession();
		session.beginTransaction();
		
		user= (User_details) session.get(User_details.class, User_ID);
		String user_name= user.getUser_name();
		int book1_id= user.getBook1_ID();
		int book2_id= user.getBook2_ID();
		
		book= (Book_details) session.get(Book_details.class, Book_ID);
		String book_name= book.getBook_name();
		Boolean availability= book.getAvailability();
		if(availability== true)
		{
			if(book1_id ==0)
			{
				user.setBook1_ID(Book_ID);
				user.setBook1_issue(date_of_issue1);
				book.setAvailability(false);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				
				model.addAttribute("user_id", User_ID);
				model.addAttribute("book_id", Book_ID);
				model.addAttribute("book_name", book_name);
				model.addAttribute("username", user_name);
				model.addAttribute("issue_date",Date_of_issue_get);
				
			/*	mv.addObject("user_id", User_ID);
				mv.addObject("book_id", Book_ID);
				mv.addObject("book_name", book_name);
				mv.addObject("username", user_name);
				mv.addObject("issue_date",Date_of_issue_get);
				*/
				
				return "issue_book_confirmation";
				
			}
			else if (book2_id ==0)
			{
				user.setBook2_ID(Book_ID);
				user.setBook2_issue(date_of_issue1);
				book.setAvailability(false);
				session.save(user);
				session.save(book);
				session.getTransaction().commit();
				session.close();
				
				model.addAttribute("user_id", User_ID);
				model.addAttribute("book_id", Book_ID);
				model.addAttribute("book_name", book_name);
				model.addAttribute("username", user_name);
				
				/*mv.addObject("user_id", User_ID);
				mv.addObject("book_id", Book_ID);
				mv.addObject("book_name", book_name);
				mv.addObject("username", user_name);*/
			
				return "issue_book_confirmation";
			}
			else
			{
				Boolean limit= true;
				model.addAttribute("book_limit_exceed", limit);
			//	mv_limit_excced.addObject("book_limit_exceed", limit);
				return "issue_book_limit";
			}
			
		}
		else
		{
			Boolean book_not_avalible= true;
			model.addAttribute("book_not_avalible", book_not_avalible);
			//mv_book_not_avalible.addObject("book_not_avalible", book_not_avalible);
			return "book_not_avalible";
		}
		
	 
    }
	

	

}


