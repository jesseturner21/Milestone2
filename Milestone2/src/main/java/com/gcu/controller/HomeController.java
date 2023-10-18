package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.SignUpModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String printHello(Model model) {
		
		//Simply return a Model with an attribute named message and return a View named home using a passed in ModelMap
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		return "home";
	}
	
	// displays the login page
	@GetMapping("/login")
	public String displayLogin(Model model) {
		System.out.print("in Login");
		model.addAttribute("title", "Login Form");
		//model.addAttribute("message", "Login");
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
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		return "home";
	}
	@PostMapping("/doSignUp")
	public String printLogin(@Valid SignUpModel signUp, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
				if(bindingResult.hasErrors()) {
					model.addAttribute("title", "Sign Up Form");
					return "signUp";
				}
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
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
