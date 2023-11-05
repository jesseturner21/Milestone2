package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.BlogEntity;
import com.gcu.data.repository.BlogRepository;
import com.gcu.model.BlogModel;

public class BlogsBusinessService implements BlogsBusinessServiceInterface{

	
	@Autowired
	BlogRepository repo;
	
	@Override
	public void test() {
		System.out.println("Hello");	
	}

	@Override
	public List<BlogModel> getBlogs() {
		// Create some Orders
		List<BlogModel> orders = new ArrayList<BlogModel>();
		
		
		return orders;
	}
	
	@Override
	public BlogEntity createBlog(String title, String author, String subtitle, String content, String date) {
        BlogEntity blog = new BlogEntity();
        blog.setTitle(title);
        blog.setAuthor(author);
        blog.setSubtitle(subtitle);
        blog.setContent(content);
        blog.setDate(date);
        
        return repo.save(blog);
        
	}

	
}
