package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.BlogEntity;
import com.gcu.data.repository.BlogRepository;
import com.gcu.model.BlogModel;

public class BlogsBusinessService implements BlogsBusinessServiceInterface{

	
	@Autowired
	BlogRepository repo;

	
	@Override
	public List<BlogEntity> findAll(){
		List<BlogEntity> blogs = new ArrayList<BlogEntity>();
		
		try {
			Iterable<BlogEntity> blogsIterable = repo.findAll();
			
			blogs = new ArrayList<BlogEntity>();
			blogsIterable.forEach(blogs::add);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return blogs;
	}
	
	@Override
	public void test() {
		System.out.println("Hello");	
	}

	@Override
	public List<BlogModel> getBlogs() {
		// Create some Blogs
		
		List<BlogEntity> blogsEntity = findAll();
		
		List<BlogModel> blogsDomain = new ArrayList<BlogModel>();
		
		for(BlogEntity entity : blogsEntity) {
			blogsDomain.add(new BlogModel(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getSubtitle(), entity.getContent(), entity.getDate()));
		}
		
		return blogsDomain;
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
