package com.gcu.business;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.BlogEntity;
import com.gcu.model.BlogModel;

public interface BlogsBusinessServiceInterface {
	public void test();
	public List<BlogModel> getBlogs();
	public BlogEntity createBlog(String title, String author, String subtitle, String content, String date);

	public List<BlogEntity> findAll();
	public BlogEntity findById(int id);
	boolean updateById();
}
