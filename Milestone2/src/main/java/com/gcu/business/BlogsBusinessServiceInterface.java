package com.gcu.business;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.BlogEntity;
import com.gcu.model.BlogModel;
@Service
public interface BlogsBusinessServiceInterface {
	public void test();
	public List<BlogModel> getBlogs();
	public BlogEntity createBlog(String title, String author, String subtitle, String content, String date);

	public List<BlogEntity> findAll();


	BlogModel findById(int id);

	public void deleteById(int id);
	BlogEntity updateBlog(BlogModel blogModel);

}
