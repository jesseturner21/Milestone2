package com.gcu.business;

import java.util.List;

import com.gcu.data.entity.BlogEntity;
import com.gcu.model.BlogModel;

public interface BlogsBusinessServiceInterface {
	public void test();
	public List<BlogModel> getBlogs();
	public BlogEntity createBlog(String title, String author, String subtitle, String content, String date);
}
