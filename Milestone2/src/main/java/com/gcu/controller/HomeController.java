package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String printHello(Model model) {
		
		//Simply return a Model with an attribute named message and return a View named hello using a passed in ModelMap
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		return "home";
	}
	@GetMapping("/login")
	public String printLogin(Model model) {
		
		model.addAttribute("title", "Login Form");
		LoginModel loginModel = new LoginModel();
		model.addAttribute(loginModel);
		
		//Simply return a Model with an attribute named message and return a View named hello using a passed in ModelMap
		model.addAttribute("message", "Login");
		return "login";
	}
	@GetMapping("/signUp")
	public String printSignUp(Model model) {
		
		//Simply return a Model with an attribute named message and return a View named hello using a passed in ModelMap
		model.addAttribute("message", "Sign Up");
		return "SignUp";
	}

}
