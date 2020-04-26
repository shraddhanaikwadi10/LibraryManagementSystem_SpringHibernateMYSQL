package com.javabycode.springmvc.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javabycode.springmvc.model.Add_user_main;
import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.Registration;
import com.javabycode.springmvc.model.User_details;
import com.javabycode.springmvc.service.StudentService;


@Controller
@RequestMapping("/view_user_home.html")
public class view_user_controller {
	@Autowired
	Add_user_main usermain;
	
	// Display the form on the get request
		@RequestMapping(method = RequestMethod.GET)
		public String showUser(Map model) {
			User_details user_details = new User_details();
			model.put("user_details", user_details);
			return "view_user_home";
		}
	
		
		@RequestMapping(method = RequestMethod.POST)
		public String getUsers(@RequestParam("user_ID") int user_ID
				,ModelMap model) throws ParseException {
		
			String book1_name=null;
			String book2_name=null;
			User_details user= new User_details();
			Book_details book = new Book_details();
			//int user_ID= user_details.getUser_ID();
			int user_ID1=user_ID;
			System.out.println("view user User id :"+user_ID1);
			//user= usermain.getuserbyid(1);
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionfactory.openSession();
			session= sessionfactory.openSession();
			session.beginTransaction();
			
			user= (User_details) session.get(User_details.class, user_ID1);
			Add_user_main usermain=new Add_user_main();
			
			String user_name= user.getUser_name();
			int book1_id= user.getBook1_ID();
			int book2_id= user.getBook2_ID();
			Date book1_issue= user.getBook1_issue();
			Date book2_issue= user.getBook2_issue();
			
			if (book1_id !=0)
			{
			book= (Book_details) session.get(Book_details.class, book1_id);
			book1_name= book.getBook_name();
			}
			else if(book2_id !=0)
			{
				book= (Book_details) session.get(Book_details.class, book2_id);
				 book2_name= book.getBook_name();
			}
			else
			{
				
			}
			
			/*ModelAndView mv= new ModelAndView();
			mv.setViewName("view_user_result.jsp");
			
			mv.addObject("user_name",user_name);
			mv.addObject("book1_id",book1_id);
			mv.addObject("book1_name",book1_name);
			mv.addObject("book1_issue",book1_issue);
			
			mv.addObject("book2_id",book2_id);
			mv.addObject("book2_name",book2_name);
			mv.addObject("book2_issue",book2_issue);
			*/
			model.addAttribute(user);
			return "view_user_result";
		}
	
}
