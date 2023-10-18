package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.BlogModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BlogController {
	
	// displays the create blog page form
	@GetMapping("/blog")
	public String displayCreateBlog(Model model) {
		System.out.println("display create blog");
		model.addAttribute("title", "Create Blog Form");
		model.addAttribute("message", "Create Blog");
		BlogModel blogModel = new BlogModel();
		model.addAttribute(blogModel);
		return "blogs";
	}
	
	// processes the input in the blog form
	@PostMapping("/createBlog")
	public String printBlog(@Valid BlogModel blog, BindingResult bindingResult, Model model) {
		System.out.println("in createBlog");
		// Check for validation errors
		if(bindingResult.hasErrors()) {
			System.out.println("has errors");
			model.addAttribute("title", "Create Blog Form");
			return "blogs";
		}
		System.out.println("home");
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		return "home";
	}

}
