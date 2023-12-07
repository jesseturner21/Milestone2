package com.gcu.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.BlogsBusinessServiceInterface;
import com.gcu.model.BlogModel;

@RestController
@RequestMapping(path="/service")
public class BlogRestService {
	
	@Autowired
	BlogsBusinessServiceInterface blogService;
	
	@GetMapping(path="/blogs")
	public ResponseEntity<?> getBlogs(){
		try {

			List<BlogModel> blogs = blogService.getBlogs();
			if(blogs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(blogs, HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping(path="/blogs/{id}")
	public ResponseEntity<?> getBlog(@PathVariable int id){
		try {

			BlogModel blog = blogService.findById(id);
			System.out.print("in get blog");
			if(blog == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(blog, HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
