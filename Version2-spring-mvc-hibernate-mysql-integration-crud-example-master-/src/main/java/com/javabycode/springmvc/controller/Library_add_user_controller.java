package com.javabycode.springmvc.controller;

import java.text.ParseException;
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

import com.javabycode.springmvc.model.Add_user_main;
import com.javabycode.springmvc.model.Book_details;
import com.javabycode.springmvc.model.User_details;


@Controller
@RequestMapping("/add_user_home.html")
public class Library_add_user_controller {
	@Autowired
	Add_user_main add_user;
	
	@RequestMapping(method = RequestMethod.GET)
	public String add_userPage(@Valid User_details user_details,BindingResult result,
			ModelMap model) throws ParseException
	{
				return "Add_user_home";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add_user(@ModelAttribute("user_details") User_details user_details,BindingResult result,
			ModelMap model) throws ParseException
	{
		String user_name= user_details.getUser_name();
		String  Address=user_details.getAddress();
		int Book1_ID=0;
		int Book2_ID=0;
		Date Book1_issue= null;
		Date Book2_issue= null;
		Date Book1_return= null;
		Date Book2_return= null;
		
		Add_user_main add_user= new Add_user_main();
		add_user.add_user_db(user_name, Address, Book1_ID, Book1_issue, Book1_return, Book2_ID, Book2_issue, Book2_return);
			
		ModelAndView mv= new ModelAndView();
		//mv.setViewName("Add_user_confirmation.jsp");
		model.addAttribute("user_name",user_name);
		model.addAttribute("Address",Address);
		return "Add_user_confirmation";
		
	}
	
	
	}

