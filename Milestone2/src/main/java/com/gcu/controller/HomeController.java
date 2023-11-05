package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.business.UserServiceInterface;
import com.gcu.model.BlogModel;
import com.gcu.model.LoginModel;
import com.gcu.model.SignUpModel;
import com.gcu.data.entity.UserEntity;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired 
	UserServiceInterface service;
	
	@Autowired
	private BlogsBusinessServiceInterface blogs;
	
	@GetMapping("/")
	public String printHello(Model model) {
		
		List<BlogModel> blogsDomain = new ArrayList<BlogModel>();
		/*
		blogsDomain.add(new BlogModel(1, "Title 1", "Author 1", "Subtitle 1", "Content 1", "Date 1"));
		blogsDomain.add(new BlogModel(2, "Title 2", "Author 2", "Subtitle 2", "Content 2", "Date 2"));
		blogsDomain.add(new BlogModel(3, "Title 3", "Author 3", "Subtitle 3", "Content 3", "Date 3"));
		blogsDomain.add(new BlogModel(4, "Title 4", "Author 4", "Subtitle 4", "Content 4", "Date 4"));
		blogsDomain.add(new BlogModel(5, "Title 5", "Author 5", "Subtitle 5", "Content 5", "Date 5"));
		*/
		//Simply return a Model with an attribute named message and return a View named home using a passed in ModelMap
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		model.addAttribute("blogsDomain", blogs.getBlogs());
		
		return "home";
	}
	
	// displays the login page
	@GetMapping("/login")
	public String displayLogin(Model model) {
		System.out.print("in Login");
		//model.addAttribute("title", "Login Form");
		model.addAttribute("message", "Login");
		LoginModel loginModel = new LoginModel();
		model.addAttribute(loginModel);
		
		return "login";
	}
	
	// displays the 
	@PostMapping("/doLogin")
	public String printLogin(@Valid LoginModel login, BindingResult bindingResult, Model model) {
		
		
		// Check for validation errors
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		//Get user with username
		UserEntity user = service.getUserByUsername(login.getUsername());
		// CHECK USERNAME
		if(user == null) {
			model.addAttribute("title", "Login Form");
			bindingResult.rejectValue("username", "wrong.username", "User does not exist");
			
			return "login";
		}
		// CHECK PASSWORD
		//if the login password is not equal to the users password send a reject message
		if(!login.getPassword().equals(service.getUserByUsername(login.getUsername()).getPassword())) {
			model.addAttribute("title", "Login Form");
			bindingResult.rejectValue("password", "wrong.password", "Incorrect Password or Username");
			
			return "login";
		}
		
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		return "home";
	}
	@PostMapping("/doSignUp")
	public String printLogin(@Valid SignUpModel signUp, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
				if(bindingResult.hasErrors()) {
					model.addAttribute("title", "Sign Up");
					return "signUp";
				}
		service.createUser(signUp.getFirstName(),signUp.getLastName() , signUp.getEmail(), signUp.getPhoneNumber(), signUp.getUsername(), signUp.getPassword());
		return "home";
	}
	@GetMapping("/signUp")
	public String printSignUp(Model model) {
		System.out.print("in signup");
		model.addAttribute("title", "Sign Up");
		SignUpModel signUpModel = new SignUpModel();
		model.addAttribute(signUpModel);
		//Simply return a Model with an attribute named message and return a View named signup using a passed in ModelMap
		return "signUp";
	}

}
