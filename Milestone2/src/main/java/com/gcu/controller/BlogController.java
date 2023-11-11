package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.BlogsBusinessService;
import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.data.entity.BlogEntity;
import com.gcu.model.BlogModel;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired 
	BlogsBusinessServiceInterface service;
	
	// displays the create blog page form
	@GetMapping("/blog")
	public String displayCreateBlog(Model model) {
		//model.addAttribute("title", "Create Blog");
		model.addAttribute("message", "Create Blog");
		BlogModel blogModel = new BlogModel();
		model.addAttribute(blogModel);


		return "blog";

	}
	
	// processes the input in the blog form
	@PostMapping("/createBlog")
	public String printBlog(@Valid BlogModel blog, BindingResult bindingResult, Model model) {
		// Check for validation errors
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Create Blog Form");

			return "blog";

		}
		if(blog.getId() == 0) {

			service.createBlog(blog.getTitle(), blog.getAuthor(), blog.getSubtitle(),blog.getContent(), blog.getDate());
			
		}
		else {
			service.updateBlog(blog);
		}
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		model.addAttribute("blogsDomain", service.getBlogs());
		return "home";
	}
	
	@GetMapping("/update/{id}")
	public String displayUpdateBlog(Model model, @PathVariable("id") int id) {
		BlogEntity blog = service.findById(id);
		BlogModel blogModel = new BlogModel();
		blogModel.setId(blog.getId());
		blogModel.setAuthor(blog.getAuthor());
		blogModel.setContent(blog.getContent());
		blogModel.setSubtitle(blog.getSubtitle());
		blogModel.setDate(blog.getDate());
		blogModel.setTitle(blog.getTitle());
		model.addAttribute("message", "Update Blog");
		model.addAttribute(blogModel);
		
		return "blog";
		
	}

	@GetMapping("/delete/{id}")
	public String deleteBlog(Model model, @PathVariable("id") int id) {
		service.deleteById(id);
		model.addAttribute("message", "Welcome to The Blog Who Cried Wolf!");
		model.addAttribute("blogsDomain", service.getBlogs());
		return "home";
		
	}

}
