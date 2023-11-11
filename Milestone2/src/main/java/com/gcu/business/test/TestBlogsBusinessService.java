package com.gcu.business.test;

import java.util.ArrayList;
import java.util.List;

import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.data.entity.BlogEntity;
import com.gcu.model.BlogModel;

public class TestBlogsBusinessService implements BlogsBusinessServiceInterface{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BlogEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
