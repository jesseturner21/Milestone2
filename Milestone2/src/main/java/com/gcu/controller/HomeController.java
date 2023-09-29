package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

import jakarta.validation.Valid;

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
	public String displayLogin(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("message", "Login");
		LoginModel loginModel = new LoginModel();
		model.addAttribute(loginModel);
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String printLogin(@Valid LoginModel login, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
				if(bindingResult.hasErrors()) {
					model.addAttribute("title", "Login Form");
					return "login";
				}
		
		return "blogs";
	}
	@GetMapping("/signUp")
	public String printSignUp(Model model) {
		
		//Simply return a Model with an attribute named message and return a View named hello using a passed in ModelMap
		model.addAttribute("message", "Sign Up");
		return "SignUp";
	}

}
